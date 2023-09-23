package com.chamy.room.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
class PrayTest {

    static Pray pray;

    @BeforeEach
    void setUp() {
        pray = new Pray("어제보다 오늘 더 하나님 사랑하고 예수님 닮아가길");
    }

    @ParameterizedTest(name = "token = {1}, expected = {2}")
    @DisplayName("동일 토큰 검증")
    @MethodSource("sameTokenParams")
    void isSameToken(Pray pray, String token, boolean expected) {
        // given
        System.out.println(token);
        // when
        boolean result = pray.isSameToken(token);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> sameTokenParams() {

        Pray pray = new Pray("어제보다 오늘 더 하나님 사랑하고 예수님 닮아가길");

        return Stream.of(
                Arguments.of(pray, pray.getToken(), true),
                Arguments.of(pray, "not token", false),
                Arguments.of(pray, "", false),
                Arguments.of(pray, null, false)
        );
    }
}
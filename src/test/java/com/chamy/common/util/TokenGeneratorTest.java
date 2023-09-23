package com.chamy.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenGeneratorTest {

    @Test
    @DisplayName("토큰 생성")
    void generate() {
        // given
        // when
        String token = TokenGenerator.generate();

        // then
        assertEquals(token.length(), 20);
    }

    @Test
    @DisplayName("Prefix 토큰 생성")
    void testGenerate() {
        // given
        String prefix = "tok_";

        // when
        String token = TokenGenerator.generate(prefix);

        // then
        assertTrue(token.startsWith(prefix));
    }
}
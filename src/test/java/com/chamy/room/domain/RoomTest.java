package com.chamy.room.domain;

import com.chamy.common.exception.BaseException;
import com.chamy.common.response.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room room;

    @BeforeEach
    void setUp() {
        room = new Room("다락방");
    }

    @Test
    @DisplayName("방 생성")
    void createRoom() {
        // given
        String name = "기쁨 다락방";

        // when
        Room joy = new Room(name);

        // then
        assertNotNull(joy);
    }

    @Test
    @DisplayName("빈 이름으로 방 생성")
    void createRoomEmptyName() {
        // given
        String name = "";

        // when
        BaseException exception = assertThrows(BaseException.class, () -> new Room(name));

        // then
        assertEquals(exception.getErrorCode(), ErrorCode.COMMON_INVALID_PARAMETER);
    }

    @Test
    @DisplayName("사람 추가")
    void addPerson() {
        // given
        String name = "채훈";

        // when
        room.addPerson(name);

        // then
        assertTrue(room.getPeopleName().contains(name));
    }

    @Test
    @DisplayName("이미 존재하는 사람 추가")
    void addPersonAlreadyExist() {
        // given
        String name = "채훈";
        room.addPerson(name);

        // when
        BaseException exception = assertThrows(BaseException.class, () -> room.addPerson(name));

        // then
        assertEquals(exception.getErrorCode(), ErrorCode.COMMON_INVALID_PARAMETER);
    }

    @Test
    @DisplayName("방 이름 변경")
    void changeName() {
        // given
        String name = "은혜 다락방";

        // when
        room.changeName(name);

        // then
        assertEquals(room.getName(), name);
    }

    @Test
    @DisplayName("비어 있는 이름으로 방 이름 변경")
    void changeNameEmptyName() {
        // given
        String name = "";

        // when
        BaseException exception = assertThrows(BaseException.class, () -> room.changeName(name));

        // then
        assertEquals(exception.getErrorCode(), ErrorCode.COMMON_INVALID_PARAMETER);
    }

    @Test
    @DisplayName("토큰으로 사람 찾기")
    void findPerson() {
        // given
        String soyeon = "소연";
        String chaehoon = "채훈";
        String jisoo = "지수";
        room.addPerson(soyeon);
        room.addPerson(chaehoon);
        room.addPerson(jisoo);
        List<Person> people = room.getPeople();
        Person sy = people.stream().filter(person -> person.isSameName(soyeon)).findFirst().get();

        // when
        Person result = room.findPerson(sy.getToken());

        // then
        assertEquals(result.getName(), soyeon);
    }

    @Test
    @DisplayName("존재하지 않는 토큰으로 사람 찾기")
    void findPersonNotExistToken() {
        // given
        String soyeon = "소연";
        String chaehoon = "채훈";
        String jisoo = "지수";
        room.addPerson(soyeon);
        room.addPerson(chaehoon);
        room.addPerson(jisoo);
        String token = "not_exist_token";

        // when
        BaseException exception = assertThrows(BaseException.class, () -> room.findPerson(token));

        // then
        assertEquals(exception.getErrorCode(), ErrorCode.COMMON_ENTITY_NOT_FOUND);
    }

    @Test
    @DisplayName("기도제목 추가")
    void addPrayTopic() {
        // given
        room.addPerson("채훈");
        Person chaehoon = room.getPeople().stream().filter(person -> person.isSameName("채훈")).findFirst().get();

        // when
        room.addPrayTopic(chaehoon.getToken(), "하나님 사랑하기");

        // then
        assertEquals(chaehoon.getPrayTopics().get(0), "하나님 사랑하기");
    }
}
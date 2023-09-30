package com.chamy.room.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    @DisplayName("기도제목 삭제")
    void removePray() {
        // given
        Person person = new Person("채훈");
        person.addPrayTopic("하나님 사랑하기");
        person.addPrayTopic("예수님 닮아가기");
        person.addPrayTopic("돈 많이 벌기");

        String prayToken = person.getPrays().stream().filter(pray -> pray.getTopic().equals("돈 많이 벌기")).findAny().get().getToken();

        // when
        person.removePray(prayToken);

        // then
        assertThat(person.getPrays()).hasSize(2);
    }
}
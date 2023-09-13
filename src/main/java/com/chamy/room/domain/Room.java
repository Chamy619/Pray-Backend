package com.chamy.room.domain;

import com.chamy.common.exception.InvalidParamException;
import com.google.common.collect.Lists;
import io.micrometer.common.util.StringUtils;

import java.util.List;

public class Room {

    private String name;
    private List<Person> people;

    public Room(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidParamException("Room.name is empty");
        }

        this.name = name;
        people = Lists.newArrayList();
    }

    public void addPerson(String name) {
        for (Person person : people) {
            if (person.isSameName(name)) {
                throw new InvalidParamException("Person.name is already exist");
            }
        }

        people.add(new Person(name));
    }

    public List<String> getPeopleName() {
        return people.stream().map(Person::getName).toList();
    }

    public String getName() {
        return name;
    }
}

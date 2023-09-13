package com.chamy.room.domain;

import com.chamy.common.exception.InvalidParamException;
import com.google.common.collect.Lists;
import io.micrometer.common.util.StringUtils;

import java.util.List;

public class Person {

    private String name;
    private List<Pray> prays;

    public Person(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidParamException("Person.name is empty");
        }

        this.name = name;
        this.prays = Lists.newArrayList();
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}

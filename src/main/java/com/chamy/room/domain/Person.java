package com.chamy.room.domain;

import com.chamy.common.exception.InvalidParamException;
import com.chamy.common.util.TokenGenerator;
import com.google.common.collect.Lists;
import io.micrometer.common.util.StringUtils;

import java.util.List;

public class Person {

    private static final String PREFIX = "per_";

    private String token;
    private String name;
    private List<Pray> prays;

    public Person(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidParamException("Person.name is empty");
        }

        this.token = TokenGenerator.generate(PREFIX);
        this.name = name;
        this.prays = Lists.newArrayList();
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public boolean isSameToken(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new InvalidParamException("Person token is empty");
        }

        return this.token.equals(token);
    }
}

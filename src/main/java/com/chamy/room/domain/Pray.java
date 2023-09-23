package com.chamy.room.domain;

import com.chamy.common.exception.InvalidParamException;
import com.chamy.common.util.TokenGenerator;
import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class Pray {

    private static final String PREFIX = "pra_";

    private String token;

    private String topic;

    public Pray(String topic) {
        if (StringUtils.isEmpty(topic)) {
            throw new InvalidParamException("Pray.topic is empty");
        }

        this.token = TokenGenerator.generate(PREFIX);
        this.topic = topic;
    }

    public boolean isSameToken(String token) {
        return this.token.equals(token);
    }
}

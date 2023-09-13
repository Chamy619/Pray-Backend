package com.chamy.room.domain;

import com.chamy.common.exception.InvalidParamException;
import io.micrometer.common.util.StringUtils;

public class Pray {
    private String topic;

    public Pray(String topic) {
        if (StringUtils.isEmpty(topic)) {
            throw new InvalidParamException("Pray.topic is empty");
        }

        this.topic = topic;
    }
}

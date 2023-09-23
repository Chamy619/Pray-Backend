package com.chamy.common.util;

import org.apache.commons.lang3.RandomStringUtils;

public class TokenGenerator {

    private static final int TOKEN_LENGTH = 20;

    public static String generate() {
        return RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH);
    }

    public static String generate(String prefix) {
        return prefix + RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH - prefix.length());
    }
}

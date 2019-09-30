package com.marios.gavriil.thriftclient.utils;

import java.util.Random;

public class Constants {

    public enum LogLevel {
        DEBUG,
        INFO,
        WARN,
        ERROR;

        public static LogLevel getRandomLevel() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

}

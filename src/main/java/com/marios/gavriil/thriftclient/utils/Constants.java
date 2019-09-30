package com.marios.gavriil.thriftclient.utils;

import java.util.Random;

public class Constants {

    public static final String DEBUG = "DEBUG";
    public static final String INFO = "INFO";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";
    public static final String DEBUG_MESSAGE = "This is a Debug log ...";
    public static final String INFO_MESSAGE = "This is a Info log ...";
    public static final String WARN_MESSAGE = "This is a Warn log ...";
    public static final String ERROR_MESSAGE = "This is a Error log ...";


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

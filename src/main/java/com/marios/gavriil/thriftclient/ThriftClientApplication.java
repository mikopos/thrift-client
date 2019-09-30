package com.marios.gavriil.thriftclient;

import com.marios.gavriil.thriftclient.services.LogsService;
import com.marios.gavriil.thriftclient.services.impl.LogsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThriftClientApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(ThriftClientApplication.class, args);
//        LogsServiceImpl logsService = new LogsServiceImpl();
//
//        logsService.logSomeStuff();
    }

}

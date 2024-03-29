package com.marios.gavriil.thriftclient.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class SpringConfiguration {

    @Bean
    public Executor taskScheduler(){
        return Executors.newScheduledThreadPool(2);
    }
}

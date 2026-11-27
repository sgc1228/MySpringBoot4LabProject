package com.inspirecamp7.myspringboot4lab.runner;

import com.inspirecamp7.myspringboot4lab.config.MyEnvironment;
import com.inspirecamp7.myspringboot4lab.properties.MyPropProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyPropRunner implements ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(MyPropRunner.class);

    @Value("${myprop.username}")
    private String username;

    @Value("${myprop.port}")
    private int port;

    @Autowired
    private MyPropProperties properties;

    @Autowired
    private MyEnvironment myEnvironment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Logger 구현 클래스 = {}", logger.getClass().getName());
        logger.info("현재 모드 = {}", myEnvironment.getMode());

        logger.debug("myprop.username = {}", username);
        logger.debug("myprop.port = {}", port);

        logger.info("MyPropProperties.getUsername() = {}", properties.getUsername());
        logger.info("MyPropProperties.getPort() = {}", properties.getPort());
    }
}

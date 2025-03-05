package com.gxy.ojquestionservice;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.gxy.ojquestionservice.mapper")
@EnableScheduling
@EnableFeignClients(basePackages = {"com.gxy.ojserviceclient.service"})
@Slf4j
@EnableRedisHttpSession
public class OjQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjQuestionServiceApplication.class, args);
        log.info("启动成功");
    }

}

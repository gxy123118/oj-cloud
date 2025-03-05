package com.gxy.ojjudgeservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@ComponentScan("com.gxy")
@Slf4j
@EnableFeignClients("com.gxy.ojserviceclient.service")
@EnableRedisHttpSession
public class OjJudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjJudgeServiceApplication.class, args);
        log.info("启动成功");
    }

}

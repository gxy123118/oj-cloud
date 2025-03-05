package com.gxy.ojuserservice;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.gxy.ojuserservice.mapper")
@Configuration("com.gxy")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@Slf4j
@EnableRedisHttpSession
@EnableFeignClients(basePackages = {"com.gxy.ojserviceclient.service"})
public class OjUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjUserServiceApplication.class, args);
      log.info("启动成功");
    }

}

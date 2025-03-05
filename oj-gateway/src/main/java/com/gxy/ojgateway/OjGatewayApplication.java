package com.gxy.ojgateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OjGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjGatewayApplication.class, args);
        log.info("启动成功");

    }

}

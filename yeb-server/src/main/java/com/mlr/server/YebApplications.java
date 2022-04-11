package com.mlr.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mlr.server.mapper")
public class YebApplications {
    public static void main(String[] args) {
        SpringApplication.run(YebApplications.class,args);
    }
}

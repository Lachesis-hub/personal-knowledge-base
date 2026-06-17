package com.personalkb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.personalkb.mapper")
@SpringBootApplication
public class PersonalKbBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalKbBackendApplication.class, args);
    }

}

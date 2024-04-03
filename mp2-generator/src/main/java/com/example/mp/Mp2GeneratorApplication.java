package com.example.mp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mp.mapper")
public class Mp2GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mp2GeneratorApplication.class, args);
    }

}

package com.qiaoyc.ctwtodo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qiaoyc.ctwtodo.mapper")
public class CtwTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtwTodoApplication.class, args);
    }

}

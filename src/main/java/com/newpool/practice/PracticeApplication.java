package com.newpool.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PracticeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(PracticeApplication.class, args);
    }
    //修改启动类，打WAR包用
  /*  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PracticeApplication.class);
    }*/
}

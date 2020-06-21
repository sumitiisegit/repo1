package com.sample.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Configuration
//@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.sample.app")
@SpringBootApplication(scanBasePackages={
        "com.sample.app"})
@EntityScan("com.sample.app.entity")
@EnableJpaRepositories("com.sample.app.repository")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}


    //curl localhost:8080/demo/add -d name=First -d
package com.timesangle.app.syntax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={
        "com.timesangle.app"})
@EntityScan("com.timesangle.app.entity")
@EnableJpaRepositories("com.timesangle.app.repository")
public class SyntaxApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SyntaxApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SyntaxApplication.class, args);
    }

}

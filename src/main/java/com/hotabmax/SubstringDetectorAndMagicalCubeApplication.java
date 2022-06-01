package com.hotabmax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SubstringDetectorAndMagicalCubeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SubstringDetectorAndMagicalCubeApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SubstringDetectorAndMagicalCubeApplication.class);
    }

}

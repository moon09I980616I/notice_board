package com.moon0.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class Moon0BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(Moon0BoardApplication.class, args);
    }

}

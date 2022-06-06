package com.example.demotest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Arrays.asList;
import static org.apache.commons.collections4.CollectionUtils.containsAny;

@SpringBootApplication
public class DemoTestApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoTestApplication.class, args);

        System.out.println("hello");

        String col = "26";

        System.out.println(containsAny(asList("25", "26", "27", "28"), col));

    }

}

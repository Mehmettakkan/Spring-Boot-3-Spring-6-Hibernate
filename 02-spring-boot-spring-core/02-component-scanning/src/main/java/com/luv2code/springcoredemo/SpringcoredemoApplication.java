package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication(
        scanBasePackages = {"com.luv2code.springcoredemo",
                            "com.luv2code.util"}
)*/
//scanBasePackages ile ana Spring package dısında olusturdugumuz package'tleri Springin taramasi
//icin yolu gosterdik.
@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}

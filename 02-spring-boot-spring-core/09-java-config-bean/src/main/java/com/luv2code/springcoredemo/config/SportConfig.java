package com.luv2code.springcoredemo.config;

 import com.luv2code.springcoredemo.common.Coach;
 import com.luv2code.springcoredemo.common.SwimCoach;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
    //Burada yaptigimiz mevcut bir ucuncu taraf sinifini almak ve ardindan onu spring uygulamalarimizda
    //kullanabilecegimiz bir bean olarak sarmak ve ortaya cikarmak.

    /*@Bean()
    public Coach swimCoach(){
        return new SwimCoach();
    }*/
}

package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
    /*@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
     *DemoController'in parametresine iki defa cricketCoach gectik newlendiginde yani kullanildiginda
     * aynı bean'i referans aliyordu.
     * Bu protatip kapsamı ile her enjeksiyon icin yeni bir instance uretecek.
     */
}

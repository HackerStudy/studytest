package com.hackerstudy.studytest.generic.boundary;

import lombok.Data;

/**
 * @class: SuperHero
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-14 18:54
 */
@Data
public class SuperHero<T extends SuperHearing & SuperSmell> {
    protected T power;

    public SuperHero() {
    }

    public SuperHero(T power) {
        this.power = power;
    }

    public void hearing(){
        power.hear();
    }

    public void smell(){
        power.smell();
    }
}

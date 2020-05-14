package com.hackerstudy.studytest.generic.boundary;

import lombok.Data;

/**
 * @class: FlashHero
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-14 19:00
 */
@Data
public class FlashHero extends SuperHero<SuperHearAndSmell> {
    public FlashHero() {
    }

    public FlashHero(SuperHearAndSmell power) {
        super(power);
    }

    public void HearAndSmell(){
        power.hear();
        power.smell();
    }
}

package com.hackerstudy.studytest.concurrent.synchronization;

/**
 * @class: Test
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-08 18:19
 */
public class Test {

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new BuyTicket()).start();
        }
    }
}

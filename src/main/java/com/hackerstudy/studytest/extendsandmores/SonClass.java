package com.hackerstudy.studytest.extendsandmores;

/**
 * @class: SonClass
 * @description:
 * @author: Administrator
 * @date: 2019-05-16 22:13
 */
public class SonClass extends SuperClass {
    int i = 8;

    @Override
    public void add(int j){
        i= i*2+j;
    }
}

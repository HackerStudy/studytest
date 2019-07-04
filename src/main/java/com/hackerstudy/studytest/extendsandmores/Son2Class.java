package com.hackerstudy.studytest.extendsandmores;

/**
 * @class: Son2Class
 * @description:
 * @author: Administrator
 * @date: 2019-05-16 22:20
 */
public class Son2Class extends SuperClass{
    int i = 8;

    Son2Class(){
        super();
//        add(1);
    }

    @Override
    public void add(int j){
        i= i*2+j;
    }
}

package com.hackerstudy.studytest.generic.pmethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @class: GenericMethod
 * @description: 泛型方法
 * @author: HackerStudy
 * @date: 2020-05-14 10:39
 */
public class GenericMethod {

    /**
     * @description: 泛型方法
     * @param: s
     * @return: void
     * @auther: HackerStudy
     * @date: 2020-05-14 10:39
     * @throws
     */
    public <T> T f(T s){
        System.out.println(s.getClass().getName());
        return s;
    }

    /**
     * @description: 泛型方法和可变的参数列表
     * @param: T[]
     * @return: List<T>
     * @auther: HackerStudy
     * @date: 2020-05-14 11:03
     * @throws
     */
    public static <T> List<T> createList(T... args){
        List<T> list = new ArrayList<T>();
        for(int i=0;i<args.length;i++){
            list.add(args[i]);
        }
        return list;
    }
}

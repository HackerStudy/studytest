package com.hackerstudy.studytest.set.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @class: SetOfInteger
 * @description: integer的随机数测试set的不重复特点
 * @author: yangpeng03614
 * @date: 2019-03-20 14:21
 */
public class SetOfInteger {
    /**
     * hashset
     */
    public static void setOfInteger(){
        Random rand = new Random(47);
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<10000;i++){
            set.add(rand.nextInt(30));
        }
        System.out.println(set);
    }

    /**
     * treeset
     */
    public  static void sortSetOfInteger(){
        Random rand = new Random(47);
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<10000;i++){
            set.add(rand.nextInt(30));
        }
        System.out.println(set);
    }

    /**
     * main方法
     * @param args
     */
    public static void main(String[] args) {
        //HashSet
        setOfInteger();
        //TreeSet
        sortSetOfInteger();
    }
}

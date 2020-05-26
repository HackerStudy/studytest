package com.hackerstudy.studytest.collection.set;

import java.util.*;

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
     * linkedset
     */
    public static void linkedsetOfInteger(){
        Random rand = new Random(47);
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<10000;i++){
            set.add(rand.nextInt(30));
        }
        System.out.println(set);
    }

    /**
     * SortedSet
     */
    public static void SortedSetOfInteger(){
        Random rand = new Random(47);
        SortedSet<Integer> set = new TreeSet<Integer>();
        for(int i=0;i<10000;i++){
            set.add(rand.nextInt(30));
        }
        System.out.println(set);
        Integer low = set.first();
        Integer high = set.last();
        System.out.println(low);
        System.out.println(high);
        SortedSet<Integer> childSet = set.subSet(low,high);
        System.out.println(childSet);
        System.out.println(set.headSet(low));
        System.out.println(set.tailSet(high));
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
        //linkedHashSet
        linkedsetOfInteger();
        //SortedSet
        SortedSetOfInteger();
    }
}

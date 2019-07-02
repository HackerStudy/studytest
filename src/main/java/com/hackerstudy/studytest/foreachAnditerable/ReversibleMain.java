package com.hackerstudy.studytest.foreachAnditerable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @class: ReversibleMain
 * @description:
 * @author: yangpeng03614
 * @date: 2019-04-02 19:13
 */
public class ReversibleMain {
    public static void main(String[] args) {
        ReversibleArrayList<String> reversibleArrayList = new ReversibleArrayList<String>(Arrays.asList("to be or not to be".split(" ")));
        System.out.println("不使用Iterable迭代器");
        for(String s:reversibleArrayList){
            System.out.print(s+"\t");
        }
        System.out.println("\n使用Iterable迭代器");
        for(String s:reversibleArrayList.reversed()){
            System.out.print(s+"\t");
        }
    }
}

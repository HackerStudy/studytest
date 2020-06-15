package com.hackerstudy.studytest.interview;

/**
 * @class: RecursionTest
 * @description: 慧通关和道乐的笔试题
 * @date: 2020-06-15 12:18
 */
public class RecursionTest {

    public static String fun(int value) {
        char[] m = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int len = m.length;
        int d = value / len;
        int r = value % len;
        return (d == 0) ? String.valueOf(m[r]) : fun(d) + m[r];
    }

    /**
     * 打印n阶乘
     * @param i
     * @return
     */
    public static int print(int i){
        if(i==1 || i==0){
            return 1;
        }
        int result = i*print(i-1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fun(50));
        System.out.println(fun(181154));
        System.out.println(fun(221629));
        System.out.println(fun(203350));

        //打印n的阶乘
        for(int i=4;i>0;i--){
            System.out.print(print(i)+" ");
        }
    }
}

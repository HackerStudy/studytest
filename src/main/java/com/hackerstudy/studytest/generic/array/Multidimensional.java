package com.hackerstudy.studytest.generic.array;

import java.util.Arrays;

/**
 * @class: Multidimensional
 * @description: 多维数组
 * @author: HackerStudy
 * @date: 2020-05-16 11:15
 */
public class Multidimensional {
    public static void main(String[] args) {
        int[][] ints = new int[1][2];
        int[][] ints1 = {{1,2},{3,4,5}};
        int[][] ints2;
        ints2 = new int[2][4];
        int[][] ints3 = new int[1][];
        for(int i=0;i<ints3.length;i++){
            ints3[i] = new int[2];
        }
        Arrays.fill(ints3,2);
        System.out.println(Arrays.toString(ints3));
    }

}

package com.hackerstudy.studytest.interview;

/**
 * @class: SolveTest
 * @description: 动态规划算法
 * @author: HackerStudy
 * @date: 2020-06-09 17:53
 */
public class SolveTest {

    public static int solve(int i){
        if(i==1){
            return 1;
        }else if(i==2){
            return 2;
        }else{
            return solve(i-1)+solve(i-2);
        }
    }

    public static void main(String[] args) {
        int total = solve(5);
        int a= solve(4);
        int b= solve(3);
        System.out.println(total);
        System.out.println(a);
        System.out.println(b);
    }
}

package com.hackerstudy.studytest.generic.pinterface;

/**
 * @class: Fibonacci
 * @description: 斐波拉西数列
 * @author: HackerStudy
 * @date: 2020-05-13 17:56
 */
public class Fibonacci implements Generator<Integer>{
    private int count = 0;

    /**
     * 递归调用生成斐波拉西数列
     * @param n
     * @return int
     */
    private int fib(int n){
        if(n<2){
            return 1;
        }else{
            return fib(n-2) + fib(n-1);
        }
    }

    @Override
    public Integer next() {
        return fib(count++);
    }
}

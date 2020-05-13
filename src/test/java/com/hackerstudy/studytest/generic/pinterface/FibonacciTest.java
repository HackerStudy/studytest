package com.hackerstudy.studytest.generic.pinterface;

import lombok.extern.java.Log;
import org.junit.Test;

/**
 * @class: FibonacciTest
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-13 18:02
 */
@Log
public class FibonacciTest {

    @Test
    public void next() {
        /*
        for循环实现的斐波拉西数列
         */
        Fibonacci fibonacci = new Fibonacci();
        for(int i=0;i<18;i++){
            int value = fibonacci.next();
            System.out.print(value+" ");
            if(i==17){
                System.out.println("");
            }
        }

        /*
        foreach循环实现的斐波拉西数列
         */
        IterableFilbonacci iterableFilbonacci = new IterableFilbonacci(18);
        for(int i:iterableFilbonacci){
            System.out.print(i+" ");
            if(iterableFilbonacci.getSize()==0){
                System.out.println("");
            }
        }
    }
}
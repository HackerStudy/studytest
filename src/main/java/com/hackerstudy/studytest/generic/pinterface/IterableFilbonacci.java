package com.hackerstudy.studytest.generic.pinterface;

import java.util.Iterator;

/**
 * @class: IterableFilbonacci
 * @description: 斐波拉西数列实现foreach形式
 * @author: HackerStudy
 * @date: 2020-05-13 18:07
 */
public class IterableFilbonacci extends Fibonacci implements Iterable<Integer>{
    //foreach的大小
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public IterableFilbonacci() {
    }

    public IterableFilbonacci(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return size>0;
            }

            @Override
            public Integer next() {
                size--;
                return IterableFilbonacci.this.next();
            }
        };
    }
}

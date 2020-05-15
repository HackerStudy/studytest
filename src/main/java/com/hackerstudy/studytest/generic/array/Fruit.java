package com.hackerstudy.studytest.generic.array;

import java.lang.reflect.Array;

/**
 * @class: Fruit
 * @description: 泛型数组
 * @author: HackerStudy
 * @date: 2020-05-15 18:44
 */
public class Fruit<T> {
    private T[] array;

    public Fruit() {
    }

    public Fruit(Class<T> tClass,int size) {
        this.array = (T[])Array.newInstance(tClass,size);
    }

    public T[] getArray() {
        return array;
    }

    public void put(int index,T value) {
        this.array[index] = value;
    }

    public T getValue(int index){
        return this.array[index];
    }
}

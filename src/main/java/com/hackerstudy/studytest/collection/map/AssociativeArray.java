package com.hackerstudy.studytest.collection.map;

import java.util.Arrays;

/**
 * @class: AssociativeArray
 * @description: 映射表(关联数组)
 * @author: HackerStudy
 * @date: 2020-05-26 15:57
 */
public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index=0;

    public AssociativeArray(int length) {
        this.pairs = new Object[length][2];
    }

    public void put(K key,V value){
        if(index>=pairs.length){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            pairs[index++]=new Object[]{key,value};
        }
    }

    public <V> V get(K key){
        for(int i=0;i<index;i++){
            if(pairs[i][0].equals(key)){
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "AssociativeArray{" +
                "pairs=" + Arrays.toString(pairs) +
                ", index=" + index +
                '}';
    }
}

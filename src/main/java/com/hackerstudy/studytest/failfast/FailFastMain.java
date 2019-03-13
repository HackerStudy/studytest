package com.hackerstudy.studytest.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @class: FailFastMain
 * @description: 测试ArrayList的failfast机制
 * @author: yangpeng03614
 * @date: 2019-03-13 09:31
 */
public class FailFastMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<6;i++){
            list.add(i);
        }
        Iterator iterator = list.iterator();
        int j=0;
        while (iterator.hasNext()){
            System.out.println("数值为："+iterator.next());
            list.remove(j);
//            iterator.remove();
            j++;
        }
        for(Integer value: list){
            System.out.println("经过迭代器操作过后的集合还剩：");
        }
    }
}

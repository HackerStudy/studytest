package com.hackerstudy.studytest.sort.collectionsort.entity;

import java.util.Comparator;

/**
 * @class: MyComparator
 * @description: 实现comparator接口来实现升序降序
 * @author: yangpeng03614
 * @date: 2019-03-26 09:19
 */
public class MyComparator implements Comparator<BeanClass> {
    @Override
    public int compare(BeanClass o1, BeanClass o2) {
        return o1.getPara() - o2.getPara(); //升序
//        return o2.getPara() - o1.getPara(); //降序
    }
}

package com.hackerstudy.studytest.sort.collectionsort.main;

import com.hackerstudy.studytest.sort.collectionsort.entity.BeanClass;
import com.hackerstudy.studytest.sort.collectionsort.entity.MyComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @class: TestCollectionSort
 * @description: 测试Collections.sort()实现升序降序
 * @author: yangpeng03614
 * @date: 2019-03-26 09:08
 */
public class TestCollectionsSort {

    public static void main(String[] args) {
        //方法一实现升序
        firstMethod();
        //方法二实现升序
        secondMethod();
        //方法三实现升序
        thirdMethod();
    }

    /**
     * BeanClass类实现Comparable接口
     */
    public static void firstMethod(){
        List<BeanClass> beanClassList = new ArrayList<>();
        beanClassList.add(new BeanClass(1));
        beanClassList.add(new BeanClass(3));
        beanClassList.add(new BeanClass(2));
        System.out.println("升序排序前");
        System.out.println(beanClassList);
        System.out.println("升序排序后");
        Collections.sort(beanClassList);
        System.out.println(beanClassList);
    }

    /**
     * MyComparator实现Comparator接口来实现升序
     */
    public static void secondMethod(){
        List<BeanClass> beanClassList = new ArrayList<>();
        beanClassList.add(new BeanClass(1));
        beanClassList.add(new BeanClass(3));
        beanClassList.add(new BeanClass(2));
        System.out.println("升序排序前");
        System.out.println(beanClassList);
        System.out.println("升序排序后");
        Collections.sort(beanClassList,new MyComparator());
        System.out.println(beanClassList);
    }

    /**
     * 匿名内部类实现Comparator接口来实现降序
     */
    public static void thirdMethod(){
        List<BeanClass> beanClassList = new ArrayList<>();
        beanClassList.add(new BeanClass(1));
        beanClassList.add(new BeanClass(3));
        beanClassList.add(new BeanClass(2));
        System.out.println("降序排序前");
        System.out.println(beanClassList);
        System.out.println("降序排序后");
        Collections.sort(beanClassList, new Comparator<BeanClass>() {
            @Override
            public int compare(BeanClass o1, BeanClass o2) {
//                return o1.getPara()-o2.getPara(); //升序
                return o2.getPara()-o1.getPara(); //降序
            }
        });
        System.out.println(beanClassList);
    }
}

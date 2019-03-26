package com.hackerstudy.studytest.sort.collectionsort.entity;

/**
 * @class: BeanClass
 * @description: 要实现升序降序的类
 * @author: yangpeng03614
 * @date: 2019-03-26 09:04
 */
public class BeanClass implements Comparable<BeanClass>{
    private int para;

    public BeanClass(int para) {
        this.para = para;
    }

    public BeanClass() {
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    @Override
    public String toString() {
        return "BeanClass{" +
                "para=" + para +
                '}';
    }


    @Override
    public int compareTo(BeanClass o) {
        return this.para-o.para; //升序
//        return o.para-this.para; //降序
    }
}

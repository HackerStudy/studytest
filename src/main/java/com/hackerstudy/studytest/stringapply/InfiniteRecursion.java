package com.hackerstudy.studytest.stringapply;

/**
 * @class: InfiniteRecursion
 * @description: 打印一个对象的内存地址
 * @author: 17911
 * @date: 2019-11-30 14:48
 */
public class InfiniteRecursion {

    /**
     * 无意识的递归
     * @return
     */
    //public String toString() {
    //    return "InfiniteRecursion address: "+ this;
    //}

    /**
     * 正确的方法来打印一个对象的内存地址（调用object的toString方法）
     * @return
     */
    @Override
    public String toString() {
        return "InfiniteRecursion address: "+ super.toString();
    }
}

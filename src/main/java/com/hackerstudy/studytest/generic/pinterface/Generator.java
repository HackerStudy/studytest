package com.hackerstudy.studytest.generic.pinterface;

/**
 * @class: Generator
 * @description: 生成器接口
 * @author: HackerStudy
 * @date: 2020-05-13 17:52
 */
public interface Generator<T> {

    /**
     * @description: 获取生成的对象
     * @return: T
     * @auther: HackerStudy
     * @date: 2020-05-13 17:53
     */
    T next();
}

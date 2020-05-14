package com.hackerstudy.studytest.util;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * @class: SetUtils
 * @description: set的工具类用来表示数学的表达式
 * @author: HackerStudy
 * @date: 2020-05-14 11:40
 */
@Slf4j
public class SetUtils {

    /**
     * @description: 并集
     * @param: [a, b]
     * @return: java.util.Set<T>
     * @auther: HackerStudy
     * @date: 2020-05-14 11:43
     * @throws
     */
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    /**
     * @description: 取交集
     * @param: [a, b]
     * @return: java.util.Set<T>
     * @auther: HackerStudy
     * @date: 2020-05-14 11:50
     * @throws
     */
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * @description: 取第一个set中和第二个不同的部分
     * @param: [a, b]
     * @return: java.util.Set<T>
     * @auther: HackerStudy
     * @date: 2020-05-14 11:54
     * @throws
     */
    public static <T> Set<T> difference(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<T>(a);
        result.removeAll(b);
        return result;
    }

    /**
     * @description: 取2个set中不同的部分
     * @param: [a, b]
     * @return: java.util.Set<T>
     * @auther: HackerStudy
     * @date: 2020-05-14 11:56
     * @throws
     */
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a,b),intersection(a,b));
    }


}

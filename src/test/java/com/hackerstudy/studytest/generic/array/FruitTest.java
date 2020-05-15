package com.hackerstudy.studytest.generic.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @class: FruitTest
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-15 18:50
 */
@Slf4j
public class FruitTest {

    /**
     * 测试泛型数组
     */
    @Test
    public void testFruit() {
        /*
        创建泛型数组:1.实例化不带泛型的数组
         */
        ArrayList<String>[] fruits = new ArrayList[5];

        /*
        创建泛型数组：2、通过Array.newInstance去创建该数组
         */
        Fruit<String> fruit = new Fruit<String>(String.class,10) ;
        fruit.put(0,"桃子");
        fruit.put(1,"西瓜");
        fruit.put(2,"香蕉");
        log.info("打印数组：{}", Arrays.toString(fruit.getArray()));
        log.info("2号元素的值：{}",fruit.getValue(2));
    }
}
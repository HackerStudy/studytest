package com.hackerstudy.studytest.generic.erase;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @class: GenericErace
 * @description: 泛型的擦除
 * @author: HackerStudy
 * @date: 2020-05-14 12:26
 */
@Slf4j
public class GenericErace {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Map<String,Object> map = new HashMap<String,Object>();
        Queue<String> queue = new LinkedList<String>();
        Stack<Integer> stack = new Stack<Integer>();
        //getTypeParameters获取其泛型声明的类型参数
        log.info(Arrays.toString(list.getClass().getTypeParameters()));
        log.info(Arrays.toString(map.getClass().getTypeParameters()));
        log.info(Arrays.toString(queue.getClass().getTypeParameters()));
        log.info(Arrays.toString(stack.getClass().getTypeParameters()));
    }
}

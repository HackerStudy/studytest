package com.hackerstudy.studytest.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @class: CollectionMethods
 * @description: Colleciton的方法测试
 * @author: HackerStudy
 * @date: 2020-05-17 11:57
 */
@Slf4j
public class CollectionMethods {

    public static void main(String[] args) {
        Collection<String> collection= new ArrayList<String>(Collections.nCopies(4,"nihao"));
        collection.add("1");
        Object[] obj = collection.toArray();
        String[] s = collection.toArray(new String[0]);
        List<String> list =new ArrayList<String>();
        list.add("nihao");
        log.info("交集:{}",collection.retainAll(list));
        log.info("max:{}",Collections.max(collection));
        log.info("min:{}",Collections.min(collection));
    }

}

package com.hackerstudy.studytest.collection.map;

import lombok.extern.slf4j.Slf4j;

/**
 * @class: MapTest
 * @description: map容器的测试类
 * @author: HackerStudy
 * @date: 2020-05-27 14:30
 */
@Slf4j
public class MapTest {

    public static void main(String[] args) {
        SlowMap<String,Object> slowMap = new SlowMap<>();
        slowMap.put("niaho",1);
        slowMap.put("niaho2",2);
        slowMap.put("niaho3",1);
        log.info(String.valueOf(slowMap.get("niaho")));
        log.info(String.valueOf(slowMap));
        log.info(String.valueOf(slowMap.entrySet()));
    }
}

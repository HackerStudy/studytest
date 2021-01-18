package com.hackerstudy.studytest.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @class: HeapOOM
 * @description: 测试内存溢出的类
 * @author: HackerStudy
 * @date: 2021-01-18 21:35
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) throws Exception {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true) {
            Thread.sleep(1);
            list.add(new OOMObject());
        }
    }
}

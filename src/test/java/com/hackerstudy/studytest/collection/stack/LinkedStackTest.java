package com.hackerstudy.studytest.collection.stack;

import lombok.extern.java.Log;
import org.junit.Test;

/**
 * @class: LinkedStackTest
 * @description: 自定义堆栈测试类
 * @author: HackerStudy
 * @date: 2020-05-13 16:46
 */
@Log
public class LinkedStackTest {

   @Test
   public void test(){
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        for (String s:"a,b,c".split(",")) {
            linkedStack.push(s);
        }

        String value;
        while((value=linkedStack.pop())!=null){
            log.info("出栈的值:"+value);
        }
    }
}
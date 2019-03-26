package com.hackerstudy.studytest.collection.stack;

import java.util.ListIterator;
import java.util.Stack;

/**
 * @class: StackMain
 * @description: java中的stack（栈）的方法测试
 * @author: yangpeng03614
 * @date: 2019-03-13 10:22
 */
public class StackMain {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String value = "Hello World";
        System.out.println("--------添加元素---------");
        for(String s:value.split(" ")){
            System.out.println("s:"+s);
            stack.push(s);
        }
        System.out.println("--------经由LinkedList遍历Stack---------");
        for(String v:stack){
            System.out.println("v:"+v);
        }
        ListIterator listIterator = stack.listIterator();
        while(listIterator.hasNext()){
            System.out.println("next:"+listIterator.next());
            System.out.println("previousIndex:"+listIterator.previousIndex());
            System.out.println("nextIndex:"+listIterator.nextIndex());
        }
        System.out.println("--------经由Stack的pop遍历Stack---------");
//        while(!stack.empty()){
//            System.out.println("Peekvalue:"+stack.peek());
//        }
        while(!stack.empty()){
            System.out.println("Pvalue:"+stack.pop());
        }

    }
}

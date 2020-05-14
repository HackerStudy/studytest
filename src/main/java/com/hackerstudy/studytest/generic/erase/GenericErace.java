package com.hackerstudy.studytest.generic.erase;

import lombok.Data;
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

        //静态内部类
        StaticInnerClass.f();

        //匿名内部类的两种方式：1.继承抽象类 ， 2.实现接口
        AnonymousInner anonymousInner = new AnonymousInner() {
            @Override
            public void f() {
                log.info("匿名内部类的实现：实现接口");
            }
        };

        AbstractAnonymousInner abstractAnonymousInner = new AbstractAnonymousInner() {
            @Override
            void f() {
                log.info("匿名内部类的实现：继承抽象类");
            }
        };

        /*
        泛型的擦除及其边界
         */
        EraceClass<String> eraceClass = new EraceClass<String>("id");

        eraceClass.objF();
    }

    /**
     * @description: 静态内部类
     * @auther: HackerStudy
     * @date: 2020-05-14 16:44
     */
    @Data
    private static class StaticInnerClass {
        public static void f(){
            log.info("静态内部类");
        }
    }
}

package com.hackerstudy.studytest.lambda;

/**
 * @class: LambdaTest
 * @description: lambda表达式的测试
 * @author: HackerStudy
 * @date: 2020-06-10 12:13
 */
public class LambdaTest {

    public static void main(String[] args) {
        anonymousInnerClass();
        multilineLambda();
        int i=onelineLambda();
        System.out.println("add():"+i);
    }

    /**
     * 用匿名内部类实现
     */
    public static void anonymousInnerClass(){
        IMessage iMessage = new IMessage() {
            @Override
            public void send(String str) {
                System.out.println(str);
            }
        };
        iMessage.send("anonymousInnerClass");
    }

    /**
     * 用lambda表达式实现
     */
    public static void multilineLambda(){
        IMessage iMessage = (str) -> {
            System.out.println(str);
        };
        iMessage.send("lambda");
    }

    public static int onelineLambda(){
        IMath iMath =  (x,y) -> x+y;
        return iMath.add(1,2);
    }
}

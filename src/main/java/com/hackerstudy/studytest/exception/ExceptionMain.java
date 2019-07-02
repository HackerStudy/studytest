package com.hackerstudy.studytest.exception;

/**
 * @class: ExceptionMain
 * @description:
 * @author: Administrator
 * @date: 2019-06-21 09:09
 */
public class ExceptionMain {

    public static void main(String[] args) {
        try{
            new CreateException().createException();
        }catch (Exception e){
            System.out.println("异常处理");
            System.out.println("getMessage:"+e.getMessage());
            System.out.println("getLocalizedMessage:"+e.getLocalizedMessage());
            System.out.println("toString:"+e.toString());
            System.out.println("printStackTrace:");
            e.printStackTrace();
            System.out.println("fillInStackTrace:");
            e.fillInStackTrace();
            System.out.println("getClass:"+e.getClass());
            System.out.println("getName:"+e.getClass().getName());
            System.out.println("getSimpleName:"+e.getClass().getSimpleName());
        }
    }
}

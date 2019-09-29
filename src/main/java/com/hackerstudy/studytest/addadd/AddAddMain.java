package com.hackerstudy.studytest.addadd;

/**
 * @class: AddAddMain
 * @description: i++和++i的问题
 * @author: Administrator
 * @date: 2019-05-16 22:01
 */
public class AddAddMain {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        int i=1,j=1;
        do{
            if(i++<++j){
                System.out.println("hello");
                continue;
            }
        }while(i<5);
        System.out.println("i:"+i+" j:"+j);
    }
}

package com.hackerstudy.studytest.enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * @class: EnumTest
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-04 15:36
 */
public class EnumTest {

    public static void main(String[] args) {
        EnumSet<StudentEnum> studentEnums=  EnumSet.allOf(StudentEnum.class);
        System.out.println(studentEnums);
        //complementOf其中的值存在于枚举中但不包含在指定的Enum_Set中的值
        studentEnums  = EnumSet.complementOf(studentEnums);
        System.out.println(studentEnums);

        EnumMap<StudentEnum,String> enumMap = new EnumMap<StudentEnum, String>(StudentEnum.class);
        enumMap.put(StudentEnum.ZHANGSAN,"张三");
        enumMap.put(StudentEnum.LISI,"李四");
        for(Map.Entry<StudentEnum,String> entry:enumMap.entrySet()){
            System.out.println("key:"+entry.getKey());
            System.out.println("value:"+entry.getValue());
        }

        for(ConstantSecificMethod constantSecificMethod:ConstantSecificMethod.values()){
            System.out.println(constantSecificMethod.getInfo());
        }
    }
}

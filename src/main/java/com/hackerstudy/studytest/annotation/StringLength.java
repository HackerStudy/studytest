package com.hackerstudy.studytest.annotation;

/**
 * @class: StringLength
 * @description: 长度测试的注解使用类
 * @author: Administrator
 * @date: 2019-07-02 21:02
 */
public class StringLength {

    @LengthDetection(max = 10,min = 2,description = "code的默认长度为2-10")
    private String code;

    public StringLength() {
    }

    public StringLength(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StringLength{" +
                "code='" + code + '\'' +
                '}';
    }
}

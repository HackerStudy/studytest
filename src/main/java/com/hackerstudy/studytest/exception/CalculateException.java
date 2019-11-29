package com.hackerstudy.studytest.exception;

/**
 * @class: CalculateException
 * @description: 算数异常（自定义异常）
 * @author: 17911
 * @date: 2019-11-29 13:26
 */
public class CalculateException extends Exception{
    public CalculateException() {
    }

    public CalculateException(String message) {
        super(message);
    }
}

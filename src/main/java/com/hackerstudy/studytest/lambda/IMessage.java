package com.hackerstudy.studytest.lambda;

/**
 * @class: IMessage
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-10 12:12
 */
@FunctionalInterface
public interface IMessage {
    void send(String str);
}

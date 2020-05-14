package com.hackerstudy.studytest.generic.erase;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @class: EraceClass
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-14 16:56
 */
@Data
@Slf4j
public class EraceClass<T extends String> {
    T obj;

    public EraceClass() {
    }

    public EraceClass(T obj) {
        this.obj = obj;
    }

    public void objF(){
        log.info(obj.toUpperCase());
    }
}

package com.hackerstudy.studytest.collection.set;

/**
 * @class: SetType
 * @description: 测试set容器
 * @author: HackerStudy
 * @date: 2020-05-26 14:45
 */
public class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetType)) return false;
        SetType setType = (SetType) o;
        return i == setType.i;
    }

    @Override
    public String toString() {
        return "SetType{" +
                "i=" + i +
                '}';
    }
}

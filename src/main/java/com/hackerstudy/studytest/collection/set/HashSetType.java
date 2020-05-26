package com.hackerstudy.studytest.collection.set;

/**
 * @class: HashSetType
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-26 14:46
 */
public class HashSetType extends SetType {

    public HashSetType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }
}

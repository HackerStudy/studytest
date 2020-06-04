package com.hackerstudy.studytest.io.serialize;

import java.io.Serializable;

/**
 * @class: Person
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-04 12:32
 */
public class Person implements Serializable {

    private String name;

    private int age;

    private transient String desc;

    public Person() {
    }

    public Person(String name, int age, String desc) {
        this.name = name;
        this.age = age;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }
}

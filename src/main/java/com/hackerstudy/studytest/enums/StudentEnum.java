package com.hackerstudy.studytest.enums;

/**
 * @class: StudentEnum
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-04 15:30
 */
public enum  StudentEnum {
    ZHANGSAN(1,"张三"),LISI(2,"李四");

    //学号
    private final int id;

    //名字
    private final String name;

    StudentEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据学号获取枚举对象
     * @param id
     * @return
     */
    public static StudentEnum getEnumById(int id) {
        for (StudentEnum studentEnum : StudentEnum.values()) {
            if (studentEnum.getId()==id) {
                return studentEnum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "StudentEnum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

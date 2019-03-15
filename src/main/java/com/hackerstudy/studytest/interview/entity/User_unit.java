package com.hackerstudy.studytest.interview.entity;

/**
 * @class: User_unit
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:53
 */
public class User_unit {
    private int id;
    private int unit_id;
    private int user_id;

    public User_unit(int id, int unit_id, int user_id) {
        this.id = id;
        this.unit_id = unit_id;
        this.user_id = user_id;
    }

    public User_unit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User_unit{" +
                "id=" + id +
                ", unit_id=" + unit_id +
                ", user_id=" + user_id +
                '}';
    }
}

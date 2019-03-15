package com.hackerstudy.studytest.interview.entity;

/**
 * @class: User
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:53
 */
public class User {
    private int user_id;
    private String user_name;
    private int user_level;

    public User(int user_id, String user_name, int user_level) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_level = user_level;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_level=" + user_level +
                '}';
    }
}

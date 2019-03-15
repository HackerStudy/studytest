package com.hackerstudy.studytest.interview.vo;

/**
 * @class: InterViewDataVo
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:54
 */
public class InterViewDataVo {
    private int id;
    private int unit_id;
    private int user_level;
    private String user_name;
    private String level_name;
    private String unit_name;

    public InterViewDataVo(int id, int unit_id, int user_level, String user_name, String level_name, String unit_name) {
        this.id = id;
        this.unit_id = unit_id;
        this.user_level = user_level;
        this.user_name = user_name;
        this.level_name = level_name;
        this.unit_name = unit_name;
    }

    public InterViewDataVo() {
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

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    @Override
    public String toString() {
        return "InterViewDataVo{" +
                "id=" + id +
                ", unit_id=" + unit_id +
                ", user_level=" + user_level +
                ", user_name='" + user_name + '\'' +
                ", level_name='" + level_name + '\'' +
                ", unit_name='" + unit_name + '\'' +
                '}';
    }
}

package com.hackerstudy.studytest.interview.vo;

/**
 * @class: TableDataVo
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:40
 */
public class TableDataVo {
    private int id;
    private String user_level;
    private String unit_name;
    private int num;

    public TableDataVo(int id, String user_level, String unit_name, int num) {
        this.id = id;
        this.user_level = user_level;
        this.unit_name = unit_name;
        this.num = num;
    }

    public TableDataVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "TableDataVo{" +
                "id=" + id +
                ", user_level='" + user_level + '\'' +
                ", unit_name='" + unit_name + '\'' +
                ", num=" + num +
                '}';
    }
}

package com.hackerstudy.studytest.interview.entity;

/**
 * @class: Unit
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:52
 */
public class Unit {
    private int unit_id;
    private String unit_name;

    public Unit(int unit_id, String unit_name) {
        this.unit_id = unit_id;
        this.unit_name = unit_name;
    }

    public Unit() {
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unit_id=" + unit_id +
                ", unit_name='" + unit_name + '\'' +
                '}';
    }
}

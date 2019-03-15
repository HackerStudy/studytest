package com.hackerstudy.studytest.interview.entity;

/**
 * @class: Level
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:53
 */
public class Level {
    private int id;
    private int level_id;
    private String level_name;

    public Level(int id, int level_id, String level_name) {
        this.id = id;
        this.level_id = level_id;
        this.level_name = level_name;
    }

    public Level() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", level_id=" + level_id +
                ", level_name='" + level_name + '\'' +
                '}';
    }
}

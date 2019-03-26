package com.hackerstudy.studytest.sort.comparable.entity;

/**
 * @class: Student
 * @description: 继承comparable接口进行内比较（按order排序）
 * @author: yangpeng03614
 * @date: 2019-03-22 10:10
 */
public class Student implements Comparable<Student>{
    private Integer id;
    private String name;
    private Integer age;
    private Double score;
    private Integer order;

    public Student(Integer id, String name, Integer age, Double score, Integer order) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.order = order;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", order=" + order +
                '}';
    }

    /**
     * 自定义排序
     * 先按照order排序，order越小的排在前面，order相等时按score排序，score越大排在前面
     * this指代的后一个Student
     * @param student
     * @return
     */
    @Override
    public int compareTo(Student student){
        if(this.order>student.order){
            return 1;
        }else if(this.order.compareTo(student.order)==0){
            return student.score.compareTo(this.score);
        }else{
            return -1;
        }
    }
}

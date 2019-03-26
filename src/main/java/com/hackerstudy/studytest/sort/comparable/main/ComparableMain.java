package com.hackerstudy.studytest.sort.comparable.main;

import com.hackerstudy.studytest.sort.comparable.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @class: ComparableMain
 * @description: 测试Comparable的排序
 * @author: yangpeng03614
 * @date: 2019-03-22 10:58
 */
public class ComparableMain {

    public static void main(String[] args) {
        //自定义排序
        customizeSort();
    }

    /**
     * 自定义排序
     */
    public static void customizeSort(){
        List<Student> students = new ArrayList<>();
        Student student = new Student(1,"张三",23,72.5,1);
        Student student1 = new Student(2,"李四",24,40.5,4);
        Student student2 = new Student(3,"王五",22,90.5,6);
        Student student3 = new Student(4,"赵六",20,80.5,1);
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        System.out.println("------排序前------");
        for(Student s:students){
            System.out.println(s);
        }
        Collections.sort(students); //collection.sort()默认的排序是自然排序（升序）
        System.out.println("------排序后------");
        for (Student s1:students){
            System.out.println(s1);
        }
    }
}

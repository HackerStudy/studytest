package com.hackerstudy.studytest.interview.dao;

import com.hackerstudy.studytest.interview.entity.Student;
import com.hackerstudy.studytest.util.JDBCUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @class: StudentDao
 * @description: 学生表
 * @author: Administrator
 * @date: 2019-08-21 22:50
 */
@Slf4j
public class StudentDao {

    /**
     * 查询出每个班成绩最好的同学的信息
     * @return
     */
    public List<Student> findRankingByClass(){
        List<Student> students = new ArrayList<Student>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 编写sql
            String sql = "select * from student where score in (select max(score) from student group by class) order by class";

            // 创建语句执行者
            st= conn.prepareStatement(sql);

            // 执行sql
            rs = st.executeQuery();

            while (rs.next()){
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String sClass = rs.getString("class");
                int score = rs.getInt("score");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setSClass(sClass);
                student.setScore(score);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, st, rs);
        }
        return students;
    }
}

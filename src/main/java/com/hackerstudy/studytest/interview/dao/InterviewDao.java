package com.hackerstudy.studytest.interview.dao;

import com.hackerstudy.studytest.interview.entity.Level;
import com.hackerstudy.studytest.interview.entity.Unit;
import com.hackerstudy.studytest.interview.util.JDBCUtils;
import com.hackerstudy.studytest.interview.vo.InterViewDataVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @class: InterviewDao
 * @description:
 * @author: yangpeng03614
 * @date: 2019-03-14 15:03
 */
public class InterviewDao {

    public List<InterViewDataVo> getTableData(){
        List<InterViewDataVo> tableDataList = new ArrayList<InterViewDataVo>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 编写sql
            String sql = "select c.id as id,c.unit_id as unit_id,a.user_level as user_level,a.user_name as user_name,d.level_name as level_name,b.unit_name as unit_name \n" +
                    "from user_unit c,unit b,user a,level d \n" +
                    "where c.unit_id = b.unit_id and c.user_id = a.user_id and d.level_id = a.user_level \n" +
                    "ORDER BY c.id";

            // 创建语句执行者
            st= conn.prepareStatement(sql);

            //设置参数
//            st.setString(1, "10");
//            st.setString(2, "测试目录");

            // 执行sql
            rs = st.executeQuery();

            while (rs.next()){
                   int id  = rs.getInt("id");
                   int unit_id = rs.getInt("unit_id");
                   int user_level = rs.getInt("user_level");
                   String user_name = rs.getString("user_name");
                   String level_name = rs.getString("level_name");
                   String unit_name = rs.getString("unit_name");
                   InterViewDataVo interViewDataVo = new InterViewDataVo();
                   interViewDataVo.setId(id);
                   interViewDataVo.setUnit_id(unit_id);
                   interViewDataVo.setUser_level(user_level);
                   interViewDataVo.setUser_name(user_name);
                   interViewDataVo.setLevel_name(level_name);
                   interViewDataVo.setUnit_name(unit_name);
                   tableDataList.add(interViewDataVo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, st, rs);
        }
        return tableDataList;
    }

    public List<Unit> getUnits(){
        List<Unit> units = new ArrayList<Unit>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 编写sql
            String sql = "select * from unit order by unit_id";

            // 创建语句执行者
            st= conn.prepareStatement(sql);

            // 执行sql
            rs = st.executeQuery();

            while (rs.next()){
                int unit_id  = rs.getInt("unit_id");
                String unit_name  = rs.getString("unit_name");
                Unit unit = new Unit();
                unit.setUnit_id(unit_id);
                unit.setUnit_name(unit_name);
                units.add(unit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, st, rs);
        }
        return units;
    }

    public List<Level> getLevels(){
        List<Level> levels = new ArrayList<Level>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 编写sql
            String sql = "select * from level order by level_id";

            // 创建语句执行者
            st= conn.prepareStatement(sql);

            // 执行sql
            rs = st.executeQuery();

            while (rs.next()){
                int id  = rs.getInt("id");
                int level_id  = rs.getInt("level_id");
                String level_name  = rs.getString("level_name");
                Level level = new Level();
                level.setId(id);
                level.setLevel_id(level_id);
                level.setLevel_name(level_name);
                levels.add(level);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, st, rs);
        }
        return levels;
    }
}

package com.hackerstudy.studytest.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Map;

/**
 * @class: JDBCUtils
 * @description: 连接mysql的jdbc
 * @author: yangpeng03614
 * @date: 2019-03-14 14:57
 */
@Slf4j
public class JDBCUtils {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://192.168.58.50:3306/interview";
    private static String username="root";
    private static String password="123456";

    private JDBCUtils(){}

    static {
        /**
         * 驱动注册和加载参数
         */
        try {
            Class jClass = JDBCUtils.class;
            Map<String,String> argMap = FileUtil.getJDBCArg();
            Constructor constructor = jClass.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object obj = constructor.newInstance();
            for(Map.Entry<String, String> entry : argMap.entrySet()){
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                Field f = jClass.getDeclaredField(mapKey);
                f.set(obj,mapValue);
            }
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        } catch (InstantiationException e) {
            log.error(e.getMessage(),e);
        } catch (InvocationTargetException e) {
            log.error(e.getMessage(),e);
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage(),e);
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(),e);
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(),e);
        }

    }

    /**
     * 获取 Connetion
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    /**
     * 释放连接 Connection
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        conn = null;
    }

    /**
     * 释放语句执行者 Statement
     * @param st
     */
    public static void closeStatement(Statement st) {
        if(st !=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        st = null;
    }

    /**
     * 释放结果集 ResultSet
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if(rs !=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        rs = null;
    }
}

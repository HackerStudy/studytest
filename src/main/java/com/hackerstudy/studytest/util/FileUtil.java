package com.hackerstudy.studytest.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @class: FileUtil
 * @description: 文件的IO流操作
 * @author: Administrator
 * @date: 2019-08-22 00:51
 */
@Slf4j
public class FileUtil {

    /**
     * 从配置文件中获取jdbc的参数
     * @throws IOException
     */
    public static Map<String,String> getJDBCArg() throws IOException {
        Map<String,String> argMap = new HashMap<>();
        File file = new File("src\\main\\resources\\jdbc.properties");
        if(!file.exists()){
            throw new IOException("该文件不存在");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8") );
        Properties prop = new Properties();
        prop.load(in);
        Set<String> propertyNames = prop.stringPropertyNames();
        for(String s:propertyNames){
            argMap.put(s,prop.getProperty(s));
        }
        in.close();
        return argMap;
    }

    /**
     * 从配置文件中获取jdbc的参数
     * @throws IOException
     */
    public static String getFileContent(String filePathname) throws IOException {
        File file = new File(filePathname);
        if(!file.exists()){
            throw new IOException("该文件不存在");
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8") );
        StringBuffer content = new StringBuffer();
        String s;
        while((s=in.readLine())!=null){
            content.append(s);
            content.append("\n");
        }
        in.close();
        return content.toString();
    }

}

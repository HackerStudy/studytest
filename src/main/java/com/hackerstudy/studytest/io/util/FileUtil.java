package com.hackerstudy.studytest.io.util;

import com.hackerstudy.studytest.interview.service.GroupAndOrderService;
import com.hackerstudy.studytest.interview.util.JDBCUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

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

}

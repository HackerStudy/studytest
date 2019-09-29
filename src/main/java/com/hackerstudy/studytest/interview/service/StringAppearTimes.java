package com.hackerstudy.studytest.interview.service;

import com.hackerstudy.studytest.util.StringUtils;
import com.hackerstudy.studytest.util.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @class: StringAppearTimes
 * @description: 一个字符串在一个文件中出现的次数
 * @author: Administrator
 * @date: 2019-08-28 20:29
 */
@Slf4j
public class StringAppearTimes {

    public static void main(String[] args) {
        try {
            String content = FileUtil.getFileContent("src\\main\\resources\\static\\file\\TextFile.txt");
            int times = StringUtils.getSameStringAppearCounts(content,"5");
            log.info("出现次数：{}",times);
//            System.out.println("出现次数："+times);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

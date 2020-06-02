package com.hackerstudy.studytest.io.files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @class: DirFilter
 * @description: 目录过滤器
 * @author: HackerStudy
 * @date: 2020-06-01 15:31
 */
public class DirFilter implements FilenameFilter {
    //正则
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File file,String name) {
        return pattern.matcher(name).matches();
    }
}

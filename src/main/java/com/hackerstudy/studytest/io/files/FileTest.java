package com.hackerstudy.studytest.io.files;

import java.io.File;
import java.util.Arrays;

/**
 * @class: FileTest
 * @description: file类的测试
 * @author: HackerStudy
 * @date: 2020-06-01 15:30
 */
public class FileTest {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length==0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s:list) {
            System.out.println(s);
        }
    }
}

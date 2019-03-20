package com.hackerstudy.studytest.set.service;

import com.hackerstudy.studytest.set.util.TextFile;

import java.io.IOException;
import java.util.TreeSet;

/**
 * @class: TestTextFile
 * @description: TextFile工具类的测试
 * @author: yangpeng03614
 * @date: 2019-03-20 14:33
 */
public class TestTextFile {

    public static void main(String[] args) {
        String pa = "src\\main\\resources\\static\\file\\主机信息.txt";
        String path2  = "D:\\ToolSoftWare\\IDEA\\WorkSpace\\MyProject\\studytest\\src\\main\\java\\com\\hackerstudy\\studytest\\set\\util\\TextFile.java";
        try {
            String file = TextFile.read(pa);
            System.out.println("fileContent:");
            System.out.println(file);
            TextFile.write("src\\main\\resources\\static\\file\\test\\text\\TextFile.txt", file);
            TextFile text = new TextFile(path2);
            for(String s:text){
                System.out.println(s);
            }
            //以换行号切分

            TreeSet<String> words = new TreeSet<String>(new TextFile("src\\main\\java\\com\\hackerstudy\\studytest\\set\\util\\TextFile.java", "\\W+"));
            /*TreeSet<String> words = new TreeSet<String>(new TextFile(path2, "\\W+"));
            非词符号切分  ,
            1. 写完整路径  D:\\xx\\xx\\xx\\bigwork\\src\\io\\TextFile.java
            2.相对于此项目（bigwork）的路径（src\io\xxx.java）
            */
            // 字母开头的 码值小于  H
            for (String string : words.headSet("H")) {
                System.out.println(string);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

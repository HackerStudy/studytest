package com.hackerstudy.studytest.collection.set.service;

import com.hackerstudy.studytest.collection.set.util.TextFile;

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
            //读取文件内容
            String file = testRead(pa);
            //将文件内容写入到指定文件
            testWrite(file);
            //以换行号切分，读取指定文件
            testTextFile(path2);
            //判断一个存在的路径是文件还是文件夹
            boolean isFile = TextFile.isFile(pa);

            //判断一个虚拟的路径是文件还是文件夹
            boolean isFile2 =TextFile.isFileOrDirctory("src\\main\\resources\\static\\file\\test\\target\\wuji.txt");

            //复制文件
            TextFile.copyFile(pa,"src\\main\\resources\\static\\file\\test\\target\\主机信息.txt");

            //复制文件通过java的Files类
            TextFile.copyFileByJavaFiles("src\\main\\resources\\static\\file\\test\\target\\主机信息.txt","src\\main\\resources\\static\\file\\copyFile\\主机.txt");

            //复制文件夹
            TextFile.copyDirectory("src\\main\\resources\\static\\file\\test\\target","src\\main\\resources\\static\\file\\copy");
            //按匹配字母或数字或下划线汉字的正则表达式来读取文件里面的内容
            testTreeSet();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试TextFile的read()方法
     * @param pa
     * @return
     * @throws IOException
     */
    public static String testRead(String pa) throws IOException{
        String file = TextFile.read(pa);
        System.out.println("fileContent:");
        System.out.println(file);
        return file;
    }

    /**
     * 测试TextFile的write()方法
     * @param file
     * @throws IOException
     */
    public static void testWrite(String file) throws IOException{
        TextFile.write("src\\main\\resources\\static\\file\\test\\text\\TextFile.txt", file);
    }

    /**
     * 测试TextFile的TextFile(String fileName)的构造方法
     * @param path2
     * @throws IOException
     */
    public static void testTextFile(String path2) throws IOException{
        TextFile text = new TextFile(path2);
        for(String s:text){
            System.out.println(s);
        }
    }

    /**
     * 测试TextFile的TextFile(String fileName,String splitter)的构造方法
     * @throws IOException
     */
    public static void testTreeSet() throws IOException{
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
    }
}

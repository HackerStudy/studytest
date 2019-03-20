package com.hackerstudy.studytest.set.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @class: TextFile
 * @description: 封装对文件的读、写操作，提供简洁的接口
 * @author: yangpeng03614
 * @date: 2019-03-20 14:30
 */
public class TextFile extends ArrayList<String> {

    //读取文件，返回 String
    public static String read(String fileName) throws IOException{
        File file = new File(fileName);
        if(!file.exists()){
            throw new IOException("该文件不存在");
        }
        StringBuilder sb  =new StringBuilder();
        BufferedReader in = new BufferedReader(
                new FileReader(
                        file.getAbsoluteFile()));
        String s ;
        //BufferedReader.readLine()  如果已到达流末尾，则返回 null
        while ( (s = in.readLine())!= null ) {
            sb.append(s);
            sb.append("\n");
            //要自己加上回车
        }
        in.close();
        return sb.toString();
    }//read

    //往文件写入 text
    public static void write(String fileName,String text) throws IOException{
        File file = new File(fileName);
        System.out.println(file.getAbsoluteFile());
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter out  = new PrintWriter
                (file.getAbsoluteFile());
            out.print(text);
            out.close();
    }//write


    //构造器
    public TextFile(String fileName,String splitter) throws IOException{
        super(Arrays.asList( read(fileName).split(splitter))) ;
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String fileName ) throws IOException{
        this(fileName, "\n");//以换行号切分
    }

    /*
     * 实现文件的拷贝
     * @param srcPathStr
     *          源文件的地址信息
     * @param desPathStr
     *          目标文件的地址信息
     */
    public static void copyFile(String srcPathStr, String desPathStr) {
        //1.获取源文件的名称
        String newFileName = srcPathStr.substring(srcPathStr.lastIndexOf("\\")+1); //目标文件地址
        System.out.println(newFileName);
        desPathStr = desPathStr + File.separator + newFileName; //源文件地址
        System.out.println(desPathStr);

        try{
            //2.创建输入输出流对象
            FileInputStream fis = new FileInputStream(srcPathStr);
            FileOutputStream fos = new FileOutputStream(desPathStr);

            //创建搬运工具
            byte datas[] = new byte[1024*8];
            //创建长度
            int len = 0;
            //循环读取数据
            while((len = fis.read(datas))!=-1){
                fos.write(datas,0,len);
            }
            //3.释放资源
            fis.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

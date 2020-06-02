package com.hackerstudy.studytest.io.files;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @class: FileRename
 * @description: 文件的重命名操作
 * @author: HackerStudy
 * @date: 2020-06-02 15:18
 */
public class FileRename {

    public static void main(String[] args) {
        //创建临时文件
        //File file=new File("D:"+File.separator+"Document"+File.separator+"temp"+File.separator+"log");
        //try {
        //    createTempFile(file);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        File renameFilePath = new  File("D:"+File.separator+"Document"+File.separator+"temp");
        MaxFile maxFile=new MaxFile(renameFilePath);
        renameFile(renameFilePath,maxFile);
    }


    public static void createTempFile(File file) throws IOException {
        if(file.isDirectory()){ //判断文件是不是目录
            for(int i=0;i<100;i++){
                new File(file,"springboot-"+getTimestamp()+"-"+i+".log").createNewFile();
            }
        }
    }

    public static void renameFile(File file,MaxFile maxFile){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files!=null) {
                for (int i = 0; i < files.length; i++) {
                    renameFile(files[i],maxFile);
                }
            }
        }else{
            String oldFileName = file.getName();
            if(oldFileName.matches("springboot\\-\\d{17}\\-\\d+\\.log")){
                String newFileName= createNewFilename(oldFileName,maxFile);
                file.renameTo(new File(file.getParentFile(),newFileName));
            }
        }
    }

    /**
     * 创建新的文件名
     * @param oldName
     * @return
     */
    public static String createNewFilename(String oldName,MaxFile maxFile){
        String prefix = oldName.substring(0,oldName.lastIndexOf("-"))+"-";
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        String oldFileNum = oldName.substring(oldName.lastIndexOf("-")+1,oldName.lastIndexOf("."));
        StringBuffer stringBuffer= new StringBuffer(oldFileNum);
        while(stringBuffer.length()<maxFile.maxNum.length()){
            stringBuffer.insert(0,0);
        }
        String newFileName = prefix+stringBuffer+suffix;
        return newFileName;
    }

    /**
     * @description: 获取当前的时间戳
     * @param: []
     * @return: java.lang.String
     * @auther: HackerStudy
     * @date: 2020-06-02 15:24
     * @throws
     */
    public static String getTimestamp(){
       Date nowDate=new Date();
       DateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
       return df.format(nowDate).toString();
    }
}

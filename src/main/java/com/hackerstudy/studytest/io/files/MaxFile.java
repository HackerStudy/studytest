package com.hackerstudy.studytest.io.files;

import java.io.File;

/**
 * @class: MaxFile
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-02 16:03
 */
public class MaxFile {
        public String maxNum="0";
        public File maxFile;

        MaxFile(File file){
            init(file);
        }

        /**
         * @description: 初始化maxfile，获取文件名最长的文件
         * @param: File file
         * @return: void
         * @auther: HackerStudy
         * @date: 2020-06-02 15:56
         * @throws
         */
        private void init(File file){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                if(files!=null){
                    for(int i=0;i<files.length;i++){
                        init(files[i]);
                    }
                }
            }else{
                if(file.getName().matches("springboot\\-\\d{17}\\-\\d+\\.log")){
                    getFileNameLengthMax(file);
                }
            }
        }

        /**
         * 获取到文件名最长的文件
         * @param file
         */
        private void getFileNameLengthMax(File file){
            String fileName= file.getName();
            String fileNum = fileName.substring(fileName.lastIndexOf("-")+1,fileName.lastIndexOf("."));
            if(Integer.parseInt(maxNum)<Integer.parseInt(fileNum)){
                maxNum=fileNum;
                maxFile =file;
            }
        }
}

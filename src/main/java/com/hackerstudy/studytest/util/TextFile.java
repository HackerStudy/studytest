package com.hackerstudy.studytest.util;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * @class: TextFile
 * @description: 封装对文件的读、写、复制操作，提供简洁的接口
 * @author: yangpeng03614
 * @date: 2019-03-20 14:30
 */
public class TextFile extends ArrayList<String> {

    /**
     * 读取文件，返回 String
     */
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
    }

    /**
     * 往指定文件写入 text
     * @param fileName
     * @param text
     * @throws IOException
     */
    public static void write(String fileName,String text) throws IOException{
        simpleCreateFileOrDirectory(fileName);
        PrintWriter out  = new PrintWriter
                (new File(fileName).getAbsoluteFile());
            out.print(text);
            out.close();
    }


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

    /**
     * 根据文件路径创建空文件（如果文件存在则不创建、文件不存在则创建文件）
     * @param fileName
     * @throws IOException
     */
    public static void createFile(String fileName) throws IOException{
        File file = new File(fileName);
        Stack<String> directorys = new Stack<String>();
        if(judgeRootPath(fileName)) {
            getNoExistDirectorys(fileName,directorys);
            if(directorys != null){
                while(!directorys.empty()){
                    File fileDirectory = new File(directorys.pop());
                    fileDirectory.mkdir();
                }
                file.createNewFile();
            }else{
                if(!file.exists()){
                    file.createNewFile();
                }
            }
        }else{
            throw new IOException("根目录不存在");
        }
    }

    /**
     * 根据文件路径创建空文件或文件夹（如果文件或文件夹存在则不创建、文件或文件夹不存在则创建文件或文件夹）
     * 使用file自带的mkdirs()方法
     * @param fileName
     * @throws IOException
     */
    public static void simpleCreateFileOrDirectory(String fileName) throws IOException{
        File file = new File(fileName);
        if(isFileOrDirctory(fileName)){
            if(judgeDirectoryExist(getFrontPath(fileName))){
            }else{
                file.mkdirs();//创建文件夹
            }
            if(judgeFileExist(fileName)){
            }else{
                file.createNewFile(); //创建文件
            }
        }else{
            if(judgeDirectoryExist(fileName)){
            }else{
                file.mkdirs();//创建文件夹
            }
        }
    }

    /**
     * 根据File文件创建空文件（如果文件存在则不创建、文件不存在则创建文件）
     * 使用file自带的mkdirs()方法
     * @param file
     * @throws IOException
     */
    public static void simpleCreateFileOrDirectory(File file) throws IOException{
        if(isFileOrDirctory(file.getAbsolutePath())){
            if(judgeDirectoryExist(getFrontPath(file.getAbsolutePath()))){
            }else{
                new File(getFrontPath(file.getAbsolutePath())).mkdirs();//创建文件夹
            }
            if(judgeFileExist(file.getAbsolutePath())){
            }else{
                file.createNewFile(); //创建文件
            }
        }else{
            if(judgeDirectoryExist(file.getAbsolutePath())){
            }else{
                file.mkdirs();//创建文件夹
            }
        }
    }

    /**
     * 获取文件路径中不存在的目录
     * @param fileName
     * @param directorys
     * @return
     */
    public static void getNoExistDirectorys(String fileName, Stack<String> directorys){
        File file = new File(fileName);
        File fileDirectory = new File(getFrontPath(file.getAbsolutePath()));
        if (!fileDirectory.exists() && !fileDirectory.isDirectory()) {
            directorys.push(fileDirectory.getAbsolutePath());
            fileName = fileDirectory.getAbsolutePath();
            getNoExistDirectorys(fileName, directorys);
        }
    }

    /**
     * 获取前置目录
     * @param filePath
     * @return
     */
    public static String getFrontPath(String filePath){
        String frontPath;
        frontPath = filePath.substring(0,filePath.lastIndexOf("\\"));
        return frontPath;
    }

    /**
     * 判断根目录是否存在
     * @param fileName
     * @return
     */
    public static boolean judgeRootPath(String fileName){
        boolean flag = true;
        File file = new File(fileName);
        String filePath = file.getAbsolutePath();
        filePath = filePath.substring(0,filePath.indexOf("\\"));
        File rootFile = new File(filePath);
        if(!rootFile.exists() && !rootFile.isDirectory()){
            flag = false;
        }
        return flag;
    }

    /**
     * 判断文件是否存在
     * @param filePath
     * @return
     */
    public static boolean judgeFileExist(String filePath){
        boolean flag = true;
        File file = new File(filePath);
        if(!file.exists()){
            flag = false;
        }
        return flag;
    }

    /**
     * 判断文件夹是否存在
     * @param directoryPath
     * @return
     */
    public static boolean judgeDirectoryExist(String directoryPath){
        boolean flag = true;
        File file = new File(directoryPath);
        if(!file.exists() && !file.isDirectory()){
            flag = false;
        }
        return flag;
    }

    /**
     * 判断该实际路径下是文件还是文件夹
     * @param path
     * @return
     */
    public static boolean isFile(String path){
        boolean flag = true;
        File file = new File(path);
        if(file.isDirectory()){
            flag = false;
        }
        if(file.isFile()){
            flag = true;
        }
        return flag;
    }

    /**
     * 判断该虚拟路径下是文件还是文件夹
     * @param path
     * @return
     */
    public static boolean isFileOrDirctory(String path){
        boolean flag = true;
        if(path.indexOf(".")==-1){
            flag = false;
        }
        return flag;
    }

    /**
     * 复制文件
     * @param sourcePath
     * @param targetPath
     */
    public static void copyFile(String sourcePath,String targetPath) throws Exception{
        if(judgeFileExist(sourcePath)){
            // 新建文件输入流并对它进行缓冲
            File sourceFile = new File(sourcePath);
            FileInputStream input = new FileInputStream(sourceFile);
            BufferedInputStream inBuff=new BufferedInputStream(input);

            // 新建文件输出流并对它进行缓冲
            File targetFile = new File(targetPath);
            simpleCreateFileOrDirectory(targetPath); //创建不存在的文件
            FileOutputStream output = new FileOutputStream(targetFile);
            BufferedOutputStream outBuff=new BufferedOutputStream(output);

            // 缓冲数组
            byte[] b = new byte[1024 * 8];
            int len;
            while ((len =inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();

            //关闭流
            inBuff.close();
            outBuff.close();
            output.close();
            input.close();
        }else{
            throw new Exception("要复制的目标文件不存在");
        }
    }

    /**
     * 复制文件
     * @param sourceFile
     * @param targetFile
     */
    public static void copyFile(File sourceFile,File targetFile) throws Exception{
        if(sourceFile.exists()){
            // 新建文件输入流并对它进行缓冲
            FileInputStream input = new FileInputStream(sourceFile);
            BufferedInputStream inBuff=new BufferedInputStream(input);

            // 新建文件输出流并对它进行缓冲
            simpleCreateFileOrDirectory(targetFile); //创建不存在的文件
            FileOutputStream output = new FileOutputStream(targetFile);
            BufferedOutputStream outBuff=new BufferedOutputStream(output);

            // 缓冲数组
            byte[] b = new byte[1024 * 8];
            int len;
            while ((len =inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();

            //关闭流
            inBuff.close();
            outBuff.close();
            output.close();
            input.close();
        }else{
            throw new Exception("要复制的目标文件不存在");
        }
    }

    /**
     * 通过java的Files类直接复制文件
     */
    public static void copyFileByJavaFiles(String sourcePath,String targetPath) throws IOException{
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        simpleCreateFileOrDirectory(targetFile); //创建不存在的文件
        Files.copy(sourceFile.getAbsoluteFile().toPath(),targetFile.getAbsoluteFile().toPath());
    }

    /**
     * 通过java的Files类直接复制文件
     */
    public static void copyFileByJavaFiles(File sourceFile,File targetFile) throws IOException{
        Files.copy(sourceFile.toPath(),targetFile.toPath());
    }

    /**
     * 复制文件夹
     * @param sourcePath
     * @param targetPath
     * @throws Exception
     */
    public static void copyDirectory(String sourcePath,String targetPath) throws Exception{
        if(isFileOrDirctory(sourcePath) && isFileOrDirctory(targetPath)){
        }else{
            if(judgeDirectoryExist(sourcePath)){
                if(judgeDirectoryExist(targetPath)){
                }else{
                    // 新建目标目录
                    File targetDir = new File(targetPath);
                    targetDir.mkdirs();
                    File sourceDir = new File(sourcePath);
                    // 获取源文件夹当前下的文件或目录
                    File[] file = sourceDir.listFiles();
                    for (int i = 0; i < file.length; i++) {
                        if (file[i].isFile()) {
                            // 源文件
                            File sourceFile=file[i];
                            // 目标文件
                            File targetFile=new
                                    File(targetDir.getAbsolutePath()
                                    +File.separator+file[i].getName());
                            copyFile(sourceFile,targetFile);
                        }
                        if (file[i].isDirectory()) {
                            // 准备复制的源文件夹
                            String dir1=sourceDir + "/" + file[i].getName();
                            // 准备复制的目标文件夹
                            String dir2=targetDir + "/"+ file[i].getName();
                            copyDirectory(dir1, dir2);
                        }
                    }
                }
            }else{
                throw new Exception("目标文件夹不存在");
            }
        }

    }
}

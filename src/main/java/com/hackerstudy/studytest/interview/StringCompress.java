package com.hackerstudy.studytest.interview;

/**
 * @class: StringCompress
 * @description: 字符串压缩问题
 * @author: HackerStudy
 * @date: 2020-06-16 11:12
 */
public class StringCompress {
    public static void main(String[] args) {
        System.out.println(compressString("aaaccddef"));
    }

    public static String compressString(String sourceString){
        StringBuffer stringBuffer = new StringBuffer();
        int len = sourceString.length();
        int low = 0;
        int high = 0;
        int count = 0;
        char c = ' ';
        while(low<len){
            high = low;
            c = sourceString.charAt(low);
            while((high<len)&&(sourceString.charAt(high)==c)){
                high++;
            }
            count = high-low;
            stringBuffer.append(c);
            stringBuffer.append(count);
            low = high;
        }
        return stringBuffer.toString();
    }
}

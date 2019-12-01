package com.hackerstudy.studytest.stringapply;

/**
 * @class: StringMain
 * @description: String的测试类
 * @author: 17911
 * @date: 2019-11-30 12:04
 */
public class StringMain {

    /**
     * 测试String类型的不变性
     */
    public static void changeString(){
        String name = "hacker";
        String newName = NoChangString.changeName(name);
        System.out.println("newName:"+newName);
        System.out.println("name:"+name);
    }

    /**
     * 打印一个对象的内存地址
     */
    public static void objectAddress(){
        InfiniteRecursion infiniteRecursion = new InfiniteRecursion();
        System.out.println(infiniteRecursion.toString());
    }

    /**
     * 测试string类型中的各个方法
     */
    public static void  TestStringMethod(){
        String start = "abdasdqweq";
        //String中字符的长度
        System.out.println("length():"+start.length());
        //String中索引位置上的char
        System.out.println("charAt():"+start.charAt(1));
        //复制指定起始和终止索引位置的字符到char数组中去
        char[] c = new char[start.length()];
        start.getChars(0,start.length(),c,0);
        System.out.println("getChars():"+c.toString());
        //生成一个char[]
        char[] newChar = start.toCharArray();
        System.out.println("toCharArray():"+newChar.toString());
        //按词典顺序比较String的内容，返回的是0，正数，负数，区分大小写
        String a = "nihao";
        String b = "NIHAO";

        System.out.println(a==b?"true":"false");
        System.out.println(a.equals(b)?"true":"false");
        if(a.compareTo(b)==0){
            System.out.println("compareTo(): a等于b");
        }else{
            System.out.println("compareTo(): a不等于b");
        }

        //包含
        System.out.println(start.contains("ab")?"contains(): "+"true":"contains(): "+"false");

        //contentEquals 比较该String的内容是否与传进来的参数StringBuffer或者是CharSequence是否一致
        StringBuffer stringBuffer = new StringBuffer(start);
        System.out.print("contentEquals: ");
        System.out.println(start.contentEquals(stringBuffer));

        //忽略大小写的比较equalsIgnoreCase()
        System.out.print("equalsIgnoreCase(): ");
        System.out.println(a.equalsIgnoreCase(b));

        //regionMatches() 比较两个字符串的某块区域是否相等
        String end = "abdaerewr";
        System.out.print("regionMatches(): ");
        System.out.println(start.regionMatches(0,end,0,5));

        //startWith() and endWith() 判断String中是以什么前缀开头和结尾的
        System.out.print("startWith(): ");
        System.out.println(start.startsWith("ab"));
        System.out.print("endWith(): ");
        System.out.println(start.endsWith("eq"));

        //从前索引，从后索引查找某个字符的索引出现的起始位置
        int startIndex = start.indexOf("ab");
        int endIndex = start.lastIndexOf("b");
        System.out.print("indexOf(): ");
        System.out.println(startIndex);
        System.out.print("lastIndexOf(): ");
        System.out.println(endIndex);

        //返回一个新的string以包含参数指定的子字符串
        String childString = start.substring(0,2);
        System.out.print("subString():");
        System.out.println(childString);

        //返回一个新的String对象，内容为原始的String对象加上参数的String
        String newConcat = start.concat("HackerStudy");
        System.out.print("concat(): ");
        System.out.println(newConcat);

        //替换字符
        String replaceString = newConcat.replace("HackerStudy","replace");
        System.out.print("replace():");
        System.out.println(replaceString);

        //大小写转换
        String caseString = newConcat.toUpperCase();
        System.out.print("toUpperCase(): ");
        System.out.println(caseString);
        caseString = newConcat.toLowerCase();
        System.out.print("toLowerCase(): ");
        System.out.println(caseString);

        //将字符两端的空白字符删除
        String trimString = " qeweq qeqw  ";
        String newTrimString = trimString.trim();
        System.out.print("trim(): ");
        System.out.println(newTrimString);

        //替换所有的空白字符
        String replaceAllString = trimString.replaceAll(" ","");
        System.out.print("replaceAll(): ");
        System.out.println(replaceAllString);

        //将其他类型转换为字符串
        String intString =  String.valueOf(2);
        System.out.print("valueOf(): ");
        System.out.println(intString);

        //如果常量池中存在当前字符串, 就会直接返回当前字符串. 如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回
        String internString = intString.intern();
        System.out.print("intern(): ");
        System.out.println(internString==intString);
    }

    /**
     * 格式化输出
     */
    public static void fomatPrint(){
        int i = 1;
        double b = 2.33434;
        System.out.println("row:"+i+","+b);
        //printf和format是一个效果
        System.out.printf("row: %d,%f\n",i,b);
        System.out.format("row: %d,%f\n",i,b);
    }

    /**
     * main方法
     * @param args
     */
    public static void main(String[] args) {
        //String类型的不变性
        changeString();

        //打印一个对象的内存地址
        objectAddress();

        //测试string类型中的各个方法
        TestStringMethod();

        //格式化输出
        fomatPrint();
    }
}

package com.hackerstudy.studytest.interview.service;

import java.math.BigInteger;

/**
 * @class: BigNumberMultService
 * @description: int的乘法
 * @author: Administrator
 * @date: 2019-08-27 16:45
 */
public class BigNumberMultService {

    /**
     * 从1乘到100(使用BigInteger实现)
     * @return
     */
    public static BigInteger MultByInteger(){
        BigInteger result = new BigInteger("1");
        BigInteger mid = new BigInteger("1");
        for(int i=1;i<101;i++){
            mid = BigInteger.valueOf(i);
            result = result.multiply(mid);
        }
        return result;
    }

    /**
     * 采用竖式运算（String）来实现1*100
     * @return
     */
    public static String MultByString(){
        String result = "";
//        for(){
//
//        }
        return result;
    }

    /**
     * 大数相乘
     * val1乘数，val2被乘数
     * @return
     */
    public static String BigNumberMult(String val1,String val2){
        String result = "";
        int[] val1s = StringToInt(val1);
        int[] val2s = StringToInt(val2);
        result = MultResult(val1s,val2s);
        return result;
    }

    /**
     *
     * @param val1
     * @param val2
     * @return
     */
    public static String MultResult(int[] val1,int[] val2){
        String result = "";
//        List<Integer> mults = new ArrayList<Integer>();
        int[] mults = new int[val1.length+val2.length+3];
        for(int i=0;i<val1.length;i++){
            for(int j=0;j<val2.length;j++){
                int num = val1[i]*val2[j];
                mults[i+j] = num+mults[i+j];
            }
        }
        int[] bitwiseSResult =  descIntNums(bitwiseCount(mults));
        result=IntNumsToString(bitwiseSResult);
        return result;
    }

    /**
     * 颠倒数组前后顺序（后变前）
     * @param nums
     * @return
     */
    public static int[] descIntNums(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(i<nums.length-1-i) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        }
        return nums;
    }

    /**
     * int数组按位组装为String
     * @return
     */
    public static String IntNumsToString(int[] nums){
        String result = "";
        for(int i =0;i<nums.length;i++){
            result = result+nums[i];
        }
        result = result.replaceFirst("^0*","");
        return result;
    }

    /**
     * 按位计算
     * @return
     */
    public static int[] bitwiseCount(int[] nums){
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(num>=10){
                nums[i] = num%10;
                nums[i+1] = nums[i+1]+num/10;
            }
        }
        return nums;
    }

    /**
     * 将String类型的整数转为Int数组（从个位开始）
     * @param val
     * @return
     */
    public static int[] StringToInt(String val){
        int[] vals = new int[val.length()];
        for(int i=0;i<vals.length;i++){
            vals[vals.length-1-i] = Integer.parseInt(val.substring(i,i+1));
        }
        return vals;
    }

    public static void main(String[] args) {
        //使用BigInteger实现1*100
        BigInteger result = MultByInteger();
        System.out.println("result: "+result);
        //使用竖式运算实现大数相乘
        String val1 = "12312331231";
        String val2 = "456312312312";
        String sResult = BigNumberMult(val1,val2);
        System.out.println("sResult: "+sResult);
    }

}

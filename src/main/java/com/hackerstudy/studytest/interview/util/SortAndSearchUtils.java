package com.hackerstudy.studytest.interview.util;

/**
 * @class: SortAndSearchUtils
 * @description: 这是一个排序和查找的工具类
 * @author: Administrator
 * @date: 2019-08-27 16:10
 */
public class SortAndSearchUtils {

    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubblingSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    /**
     * 折半查找(折半查找的先决条件是查找表中的数据元素必须有序)
     * @param nums
     * @param temp
     * @param start
     * @param end
     * @return
     */
    public static int binarySearch(int[] nums,int temp,int start,int end){
        if(start>end) {
            return -1;
        }else{
            int mid = (start+end)/2;
            if(nums[mid]==temp){
                return mid;
            }else {
                if(temp<nums[mid]) {
                    return binarySearch(nums, temp, start, mid - 1);
                }else {
                    return binarySearch(nums, temp, mid + 1, end);
                }
            }
        }
    }
}

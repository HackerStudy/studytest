package com.hackerstudy.studytest.interview.service;

import com.hackerstudy.studytest.util.SortAndSearchUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @class: SortAndSearchTest
 * @description: 测试，冒泡排序和折半查找
 * @author: Administrator
 * @date: 2019-08-27 21:47
 */
@Slf4j
public class SortAndSearchTest {

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,9,6,8,7};
        //冒泡排序
        System.out.println("排序前: ");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
        SortAndSearchUtils.bubblingSort(nums);
        System.out.println("\n排序后: ");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
        //折半查找
        int index = SortAndSearchUtils.binarySearch(nums,8,0,nums.length-1);
        System.out.println("\n8的下标是: "+index);
    }
}

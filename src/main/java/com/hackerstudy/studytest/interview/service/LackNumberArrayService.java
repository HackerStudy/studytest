package com.hackerstudy.studytest.interview.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @class: ArrayService
 * @description:
 * @author: Administrator
 * @date: 2019-08-21 17:56
 */
public class LackNumberArrayService {

    /**
     * 找出数组中缺失的数字（一对一对的乱序数组）
     * @return
     */
    public static int getLackNumber(Integer[] oldArray){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(oldArray));
        int i = 0;
        List<Integer> pairsList = new ArrayList<Integer>();
        for(Integer number:list){
            for(int j=i+1;j<list.size();j++){
                if(number.equals(list.get(j))){
                    pairsList.add(i);
                    pairsList.add(j);
                    break;
                }
            }
            i++;
        }
        int k = 0;
        int lackNumber = 0;
        for(Integer pairsIndex:pairsList){
            if(k!=pairsIndex){
                lackNumber = list.get(k);
                break;
            }
            k++;
        }
        return lackNumber;
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    /**
     * 二分查找
     * @param r
     * @param low
     * @param high
     * @param k
     * @return
     */
    public static int binarySearch(int r[],int low,int high,int k) {
        if(low>high) {
            return -1;
        }else{
            int mid=(low+high)/2;
            if(r[mid]==k) {
                return mid;
            }else{
                if(r[mid]<k) {
                    return binarySearch(r, mid + 1, high, k);
                } else {
                    return binarySearch(r, low, mid - 1, k);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] oldArray = {1,1,5,4,5,6,6};//案例数组
        int lackNumber = getLackNumber(oldArray);
        System.out.println("缺失的数字是："+lackNumber);
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: AppearTime.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 数字在升序数组中出现的次数
 * @Author: Administrator
 * 描述
 * 统计一个数字在升序数组中出现的次数。
 * 示例1
 * 输入：
 * [1,2,3,3,3,3,4,5],3
 * 复制
 * 返回值：
 * 4
 * @Date: 2021/6/28 18:16
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class AppearTime {

    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0){
            return 0;
        }
        return getTime(array, k);
    }
    
    private int getTime(int [] array , int k){
        int start = 0;
        int end = array.length-1;
        while (start<end){
            //计算中位数
            int middle = (end + start) / 2;
            if(array[middle]>k){
                end = middle;
            }else if(array[middle]<k){
                start = middle;
            }else{
                int count = 0;
                for (int i = start; i <= end; i++) {
                    if(array[i] == k){
                        count++;
                    }
                }

                return count;
            }
            
        }
        
        return 0;
    }
    

    public static void main(String[] args) {
        int[] ints = {1,3, 3, 3, 3, 4, 5};
        AppearTime appearTime = new AppearTime();
        appearTime.GetNumberOfK(ints, 3);
    }
}

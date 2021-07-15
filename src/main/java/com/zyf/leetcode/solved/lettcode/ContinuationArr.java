package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: continuationArr.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 连续子数组的最大和
 * @Author: Administrator
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入：
 * [1,-2,3,10,-4,7,2,-5]
 * 复制
 * 返回值：
 * 18
 * 复制
 * 说明：
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。 
 * @Date: 2021/7/9 18:01
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class ContinuationArr {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum<0?array[i]:sum+array[i];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}

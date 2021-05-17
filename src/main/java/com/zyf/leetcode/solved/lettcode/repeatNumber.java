package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: repeatNumber.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 重复的数字
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 * @Author: Administrator
 * @Date: 2021/5/17 16:09
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class repeatNumber {
    
    public int getRepeatNumber(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i){
                //当前值
                int num = numbers[i];
                //交换目标值
                int tageNum = numbers[num];
                //如何当前值和目标索引值相同，则表示重复
                if(tageNum == num){
                    return tageNum;
                }
                //交换
                numbers[i] = tageNum;
                numbers[num] = num;
            }
        }
        return -1;
    }
}

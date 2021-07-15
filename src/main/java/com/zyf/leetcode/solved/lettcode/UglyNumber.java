package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: UglyNumber.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 丑数
 * @Author: Administrator
 * @Date: 2021/7/12 18:21
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {

        if(index ==1 || index==0){
            return index;
        }

        int[] result = new int[index];
        result[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[p1]*2, Math.min(result[p2]*3, result[p3]*5));
            if(result[i] == result[p1]*2){
                p1++;
            }
            if(result[i] == result[p2]*3){
                p2++;
            }
            if(result[i] == result[p3]*5){
                p3++;
            }
        }

        return result[index-1];
    }
    
}

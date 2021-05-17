package com.zyf.leetcode.solved.lettcode;

import java.util.Map;

/**
 * @Title: SquareSum.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * @Author: Administrator
 * @Date: 2021/4/28 16:17
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SquareSum {

    public boolean judgeSquareSum(int c) {
        Long start = 0L;
        while (start*start<=c){
            double sqrt = Math.sqrt(c - start * start);
            if(sqrt ==(int)sqrt){
                return true;
            }
            
            start++;
        }
        
        return false;
    }
    
    public boolean judgeSquareSum2(int c) {
        
        long left = 0;
        long right = (long)Math.sqrt(c);
        while (left<=right){
            long tmp = left * left +right * right;
            if(tmp == c){
                return true;
            }

            if(tmp>c){
                right--;
            }else {
                left++;   
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SquareSum squareSum = new SquareSum();
        System.out.println(squareSum.judgeSquareSum2(5));
    }
}

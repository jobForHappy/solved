package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: RoundFigurePower.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
 *
 * 示例1
 * 输入：
 * 2.00000,3
 * 复制
 * 返回值：
 * 8.00000
 * 复制
 * 示例2
 * 输入：
 * 2.10000,3
 * 复制
 * 返回值：
 * 9.26100
 * 复制
 * 示例3
 * 输入：
 * 2.00000,-2
 * 复制
 * 返回值：
 * 0.25000
 * 复制
 * 说明：
 * 2的-2次方等于1/4=0.25
 * @Author: Administrator
 * @Date: 2021/6/29 18:20
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RoundFigurePower {
    public double Power(double base, int exponent) {
        
        if(exponent == 0){
            return 1;
        }

        double result = base;
        if(exponent<0){
            for (int i = exponent+1; i < 0; i++) {
                result = result*base;
            }
            
            return  (1.0/result);
        }

        for (int i = 1; i < exponent; i++) {
            result = result*base;
        }
        
        return result;
    }
    
}

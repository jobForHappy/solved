package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: Pow.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * @Author: Administrator
 * @Date: 2021/3/15 17:50
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class Pow {
    public double myPow(double x, int n) {
        return n>0? calculate(x,n): 1/calculate(x,-n);
    }
    
    private double calculate(double x, int n){
        
        //如果n = 0则返回1
        if(n == 0){
            return 1.0;
        }

        double calculate = calculate(x, n / 2);
        if(n%2 ==0){
            return calculate * calculate;
        }else{
            return calculate * calculate *x;
        }
        
    }
    
}

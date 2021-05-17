package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: CountWithOutSymbol.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 不要加减乘除求和
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @Author: Administrator
 * @Date: 2021/4/28 15:20
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class CountWithOutSymbol {
    public int add1(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add1(a ^ b, (a & b) << 1);
    }

    public int add2(int a, int b) {
        if (b == 0) {
            return a;
        }

        // 转换成非进位和 + 进位
        return add2(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        CountWithOutSymbol countWithOutSymbol = new CountWithOutSymbol();
        System.out.println(countWithOutSymbol.add1(111,899));
        System.out.println(countWithOutSymbol.add2(111,899));
    }
}

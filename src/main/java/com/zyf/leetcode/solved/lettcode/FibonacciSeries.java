package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: FibonacciSeries.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n\leq 39n≤39
 * <p>
 * 示例1
 * 输入：
 * 4
 * 复制
 * 返回值：
 * 3
 * f(n) = f(n-1)+f(n-2)
 * f(2) = f(1)+f(0)
 * @Author: Administrator
 * @Date: 2021/7/8 17:06
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FibonacciSeries {
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        //f(n-1)
        int front = 1;
        //f(n-1)
        int behind = 0;
        for (int i = 2; i <= n; i++) {
            int tmp = front + behind;
            behind = front;
            front = tmp;
        }

        return front;
    }
}

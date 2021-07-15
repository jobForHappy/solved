package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: GiftMax.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 礼物的最大价值
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 *
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 * @Author: Administrator
 * @Date: 2021/7/12 17:26
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class GiftMax {
    public int getMost(int[][] values) {
        if(values == null || values[0].length==0||values.length==0){
            return 0;
        }
        
        int[][] dp = new int[values.length][values[0].length];
        dp[0][0] = 1;
        for (int i = 1; i < values[0].length; i++) {
            dp[0][i] = dp[0][i-1]+values[0][i];
        }
        for (int i = 1; i < values.length; i++) {
            dp[i][0] = dp[i-1][0]+values[i][0];
        }

        for (int i = 1; i < values.length; i++) {
            for (int j = 1; j < values[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j]+values[i][j], dp[i][j-1]+values[i][j]);
            }
        }
        
        return dp[values.length][values[0].length];
    }
}

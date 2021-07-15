package com.zyf.leetcode.solved.lettcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title: DiceNumber.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: n 个骰子的点数
 * 把 n 个骰子扔在地上，求点数和为 s 的概率。
 * @Author: Administrator
 * @Date: 2021/7/14 17:52
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class DiceNumber {

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {

        if(n == 0){
            return null;
        }
        
        //塞子的最大数
        int dices = 6;
        
        //n对应的数字次数
        int[][] number = new int[n+1][n*dices+1];
        //当n =1时，各个数字的次数
        for (int i = 0; i < dices; i++) {
            number[1][i]= 1;
        }
        
        //遍历n次，获取出现某个数字的次数
        for (int i = 2; i < dices; i++) {
            for (int j = i; j < i*dices; j++) {
                for (int k = 1; k <= j && k<dices; k++) {
                    number[i][j]+=number[i-1][j-k];
                }
            }
        }
        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
        //摇骰子的总次数
        double pow = Math.pow(dices, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i < pow; i++) {
            ret.add(new AbstractMap.SimpleEntry(i, number[n][i]/pow));
        }
        
        return ret;
    }
}

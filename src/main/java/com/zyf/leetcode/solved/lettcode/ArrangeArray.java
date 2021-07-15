package com.zyf.leetcode.solved.lettcode;

import java.util.Arrays;

/**
 * @Title: ArrangeArray.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @Author: Administrator
 * @Date: 2021/7/2 17:06
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class ArrangeArray {
    
    public String PrintMinNumber(int[] numbers) {
        String[] tmp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            tmp[i] = numbers[i] + "";
        }

        Arrays.sort(tmp, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            stringBuilder.append(tmp[i]);
        }
        return stringBuilder.toString();
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Title: StringArrange.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 字符串的排列
 * @Author: Administrator
 * 描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述：
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例1
 * 输入：
 * "ab"
 * 复制
 * 返回值：
 * ["ab","ba"]
 * @Date: 2021/7/1 17:46
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class StringArrange {

    ArrayList<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        find(chars, new boolean[chars.length]);
        return result;
    }

    private void find(char[] chars, boolean[] cache) {

        if (stringBuilder.length() == chars.length) {
            if(!result.contains(stringBuilder.toString())){
                result.add(stringBuilder.toString());
            }
            
        }

        for (int i = 0; i < chars.length; i++) {
            if (cache[i]) {
                continue;
            }
            cache[i] = true;
            stringBuilder.append(chars[i]);
            find(chars, cache);
            cache[i] = false;
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        }

    }
}

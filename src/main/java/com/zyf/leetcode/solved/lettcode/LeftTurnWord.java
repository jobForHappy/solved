package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: LeftTurnWord.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 左旋转字符串
 * @Author: Administrator
 * @Date: 2021/5/26 17:22
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class LeftTurnWord {

    public String LeftRotateString(String str,int n) {
        if(str == null || str ==""){
            return "";
        }
        if(n == 0){
            return str;
        }
        String substring = str.substring(0, n);
        String substring1 = str.substring(n, str.length() - 1);
        return substring1+substring;
    }

    public static void main(String[] args) {
        LeftTurnWord leftTurnWord = new LeftTurnWord();
        leftTurnWord.LeftRotateString("", 6);
    }
}

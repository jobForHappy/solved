package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: ReplaceBlank.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 替换空格
 * 将一个字符串中的空格替换成 "%20"。
 *
 * Input:
 * "A B"
 *
 * Output:
 * "A%20B"
 * @Author: Administrator
 * @Date: 2021/5/17 17:14
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class ReplaceBlank {
    public String replaceSpace (String s) {
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(s.charAt(i));
            }
        }
        
        return stringBuilder.toString();
    }
}

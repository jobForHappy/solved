package com.zyf.leetcode.solved.lettcode;

import java.util.HashMap;

/**
 * @Title: FindOnlyOneCharacter.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 查找只出现一次的字符位置
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
 *
 * Input: abacc
 * Output: b
 * 解题思路
 * @Author: Administrator
 * @Date: 2021/5/18 17:13
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindOnlyOneCharacter {
    public int FirstNotRepeatingChar(String str) {
        
        HashMap<Character, Integer> map = new HashMap((int)(str.length()/0.75));
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), 1);
            }else{
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
            
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
    
}

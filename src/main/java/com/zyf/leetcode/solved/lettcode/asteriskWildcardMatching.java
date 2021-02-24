package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: asteriskWildcardMatching.java
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 通配符匹配
 * @Author: Administrator
 * @Date: 2021/2/22 17:52
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class asteriskWildcardMatching {
    public boolean isMatch(String s, String p) {
        //状态数组
        int[][] res = new int[s.length()+1][p.length()+1];
        //初始化状态
        res[0][0] = 1;
        //p头部的*初始化
        for (int i = 1; i <= p.length(); i++) {
            if(p.charAt(i-1) == '*'){
                res[0][i] = 1;
            }else{
                break;
            }
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='?'){
                    res[i][j] = res[i-1][j-1];
                }
                
                if(p.charAt(j-1) == '*'){
                    if(res[i-1][j] ==1 || res[i][j-1]==1){
                        res[i][j] =  1;
                    }
                }
            }
        }
        return res[s.length()][p.length()] == 1;
    }

}

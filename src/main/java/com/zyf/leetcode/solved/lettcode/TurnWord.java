package com.zyf.leetcode.solved.lettcode;

import java.util.Stack;

/**
 * @Title: TurnWord.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“nowcoder. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a nowcoder.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 示例1
 * 输入：
 * "nowcoder. a am I"
 * 复制
 * 返回值：
 * "I am a nowcoder."
 * @Author: Administrator
 * @Date: 2021/5/26 16:49
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class TurnWord {

    /**
     * 利用栈的翻转
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {

        Stack<String> st = new Stack<>();
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            st.push(s[i]);
            st.push(" ");
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        TurnWord turnWord = new TurnWord();
        System.out.println(turnWord.ReverseSentence("nowcoder. a am I"));
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title: FindFirstSignal.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 第一个只出现一次的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 * @Author: Administrator
 * @Date: 2021/5/24 16:08
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindFirstSingle {
    /**
     * 全量保存，用来判断是否已经存在
     */
    HashMap<Character, Integer> hp = new HashMap();

    List<Character> single = new ArrayList<>();

    public void Insert(char ch) {
        //如果不包含，则是第一次出现加入容器
        if (!hp.containsKey(ch)) {
            hp.put(ch, 1);
            single.add(ch);
        } else {
            //如果值为1，则表明之前放入到list中的还没有移除
            if (hp.get(ch) == 1) {
                single.remove(Character.valueOf(ch));
                hp.put(ch, 0);
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (single.isEmpty()) {
            return '#';
        }
        return single.get(0);
    }

    public static void main(String[] args) {
        FindFirstSingle sg = new FindFirstSingle();
        sg.Insert('g');
        sg.Insert('o');
        System.out.println(sg.FirstAppearingOnce());
        sg.Insert('o');
        sg.Insert('g');
        sg.Insert('l');
        System.out.println(sg.FirstAppearingOnce());
        sg.Insert('e');
        sg.Insert('l');
        System.out.println(sg.FirstAppearingOnce());
    }
}

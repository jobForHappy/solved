package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: RandomListNode.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 复杂连表
 * @Author: Administrator
 * @Date: 2021/5/31 18:06
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RandomListNode {

    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

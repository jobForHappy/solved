package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: TreeLinkNode.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 中续遍历节点定义
 * @Author: Administrator
 * @Date: 2021/6/4 18:20
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

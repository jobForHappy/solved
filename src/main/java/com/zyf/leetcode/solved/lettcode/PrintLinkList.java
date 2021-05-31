package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;

/**
 * @Title: printLinkList.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 打印连表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 示例1
 * 输入：
 * {67,0,24,58}
 * 复制
 * 返回值：
 * [58,24,0,67]
 * @Author: Administrator
 * @Date: 2021/5/26 18:11
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class PrintLinkList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        //反转链表
        ListNode lastNode = null;
        ListNode currentNode = listNode;
        while (currentNode != null) {
            ListNode tmp = currentNode.next;
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = tmp;
        }

        while (lastNode != null) {
            list.add(lastNode.val);
            lastNode = lastNode.next;

        }
        return list;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;

        PrintLinkList printLinkList = new PrintLinkList();
        printLinkList.printListFromTailToHead(listNode1);
    }
}

package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: FindEnter.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 * @Author: Administrator
 * @Date: 2021/5/28 18:31
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindEnter {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        //慢指针
        ListNode slow = pHead;

        //快指针
        ListNode fast = pHead;

        if (pHead.next == null) {
            return pHead;
        }

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast || fast != null);

        if (fast != slow) {
            return null;
        }

        //重置慢节点
        slow = pHead;
        //再次相遇的点为入口点
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}

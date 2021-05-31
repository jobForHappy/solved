package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: MergeLinkNode.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 示例1
 * 输入：
 * {1,3,5},{2,4,6}
 * 复制
 * 返回值：
 * {1,2,3,4,5,6}
 * @Author: Administrator
 * @Date: 2021/5/31 17:22
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MergeLinkNode {

    public ListNode Merge(ListNode list1,ListNode list2) {
        
        if(list1 == null && list2 == null){
            return null;
        }
        
        ListNode  current = new ListNode(-1);
        ListNode result = current;
        while (list1!=null || list2!=null){
            if(list1 == null){
                current.next = list2;
                break;
            }
            if(list2 == null){
                current.next = list1;
                break;
            }
            if(list1.val> list2.val){
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }else if(list1.val<=list2.val){
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            }
        }
        
        return result.next==null? null : result.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode3;
        listNode3.next = listNode5;
        
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode2.next = listNode4;
        listNode4.next = listNode6;
        MergeLinkNode mergeLinkNode = new MergeLinkNode();
        mergeLinkNode.Merge(listNode1, listNode2);
    }
}

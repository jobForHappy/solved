package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: RemoveLinkNode.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 在 O(1) 时间内删除链表节点
 * @Author: Administrator
 * @Date: 2021/5/27 17:12
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RemoveLinkNode {
    
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if(head == null || tobeDelete == null){
            return head;
        }
        //不是尾节点，那把要删除的节点变为下一个节点
        if(tobeDelete.next!=null){
            ListNode next = tobeDelete.next;
            tobeDelete.next = next.next;
            tobeDelete.val = next.val;
        }else{
            head.next = null;
        }
        
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        RemoveLinkNode removeLinkNode = new RemoveLinkNode();
        removeLinkNode.deleteNode(listNode1, listNode2);
    }
}

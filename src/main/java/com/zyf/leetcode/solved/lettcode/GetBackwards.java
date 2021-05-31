package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: GetBackwards.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 * @Author: Administrator
 * @Date: 2021/5/28 17:10
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class GetBackwards {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 实现思路：倒数第k个就是正数的第length-k个
     *
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        
        //获取连表长度
        int length = 0;
        ListNode tmp = pHead;
        while (tmp!=null){
            length++;
            tmp = tmp.next;
        }
        
        //计算正数的个数
        length = length-k;
        
        if(length<0){
            return null;
        }
        while (pHead!=null){
            if(length == 0){
                return pHead;
            }
            pHead = pHead.next;
            length--;
        }
        
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        GetBackwards getBackwards = new GetBackwards();
        getBackwards.FindKthToTail(listNode1, 5);
    }
}

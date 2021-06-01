package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: crossoverPoint.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 两个链表的第一个公共结点
 * @Author: Administrator
 * @Date: 2021/6/1 17:58
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class CrossoverPoint {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;
        while (tmp1 != tmp2) {
            if (tmp1 == null) {
                tmp1 = pHead2;
            }else{
                tmp1 = tmp1.next;
            }
            if (tmp2 == null) {
                tmp2 = pHead1;
            }else{
                tmp2 = tmp2.next; 
            }
            
            

        }
        return tmp1;
    }
}

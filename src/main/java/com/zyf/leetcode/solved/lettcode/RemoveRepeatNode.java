package com.zyf.leetcode.solved.lettcode;

import java.util.HashMap;

/**
 * @Title: RemoveRepeatNode.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author: Administrator
 * @Date: 2021/5/27 17:45
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RemoveRepeatNode {

    public ListNode deleteDuplication(ListNode pHead) {

        HashMap<Integer, Integer> map = new HashMap<>(128);

        ListNode tmp = pHead;
        while (tmp!=null){
            //用map来标记重复，如果不重复为0，重复为1
            if(map.containsKey(tmp.val) && map.get(tmp.val) == 0){
                map.put(tmp.val, 1);
            }else if(!map.containsKey(tmp.val)){
                map.put(tmp.val, 0);
            }
            tmp = tmp.next;
        }
        
        //去除重复的点
        ListNode removeTmp = pHead;
        ListNode behindTmp = null;
        while(removeTmp!=null){
            //重复,把他变成下一个节点
            if(map.get(removeTmp.val) == 1){
                if(removeTmp.next!=null){
                    removeTmp.val = removeTmp.next.val;
                    removeTmp.next = removeTmp.next.next;
                }else{
                    if(behindTmp==null){
                        return null;
                    }
                    behindTmp.next = null;
                    removeTmp = null;
                }
            }else{
                behindTmp = removeTmp;
                removeTmp = removeTmp.next;
                
            }
        }
        
        return pHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        RemoveRepeatNode removeRepeatNode = new RemoveRepeatNode();
        removeRepeatNode.deleteDuplication(listNode1);
    }
    
}

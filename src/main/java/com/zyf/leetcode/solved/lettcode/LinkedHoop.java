package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: Linkedhoop.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 连表环
 * @Author: Administrator
 * @Date: 2021/4/25 14:32
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class LinkedHoop {

    private Node link;

    class Node {
        private String value;
        private Node next;

        void node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 判断是否有环
     *
     * @return
     */
    public Boolean haveHoop(Node link) {
        //快自增
        Node fast = link;
        //慢指针
        Node slow = link;
        while (slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    /**
     * 入口点
     * @param link
     * @return
     */
    public Node enterNode(Node link){
        //快自增
        Node fast = link;
        //慢指针
        Node slow = link;
        while (slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        
        //慢指针从头开始，快指针从当前位置开始
        slow = link;
        
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}

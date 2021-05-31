package com.zyf.leetcode.solved.lettcode;

import java.util.HashMap;

/**
 * @Title: complicatedLinkCopy.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，
 * 并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Author: Administrator
 * @Date: 2021/5/31 18:05
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class ComplicatedLinkCopy {

    /**
     * 已创建节点map
     */
    
    HashMap<Integer, RandomListNode> preCreateMap = new HashMap();

    public RandomListNode clone(RandomListNode pHead) {
        RandomListNode copy = new RandomListNode(-1);
        RandomListNode current = copy;
        while (pHead!=null){
            //创建拷贝节点
            RandomListNode copyTmp = create(pHead);
            
            //创建随机节点
            RandomListNode randomCopyTmp = pHead.random==null? null:create(pHead.random);
            //将拷贝节点指向拷贝的随机节点
            copyTmp.random = randomCopyTmp;
            //将拷贝节点指向当前拷贝节点
            current.next = copyTmp;
            current = current.next;
            pHead = pHead.next;
        }
        
        return copy.next;
    }

    /**
     * 创建节点
     */
    public RandomListNode create(RandomListNode node){
        //判断是否存在
        if(preCreateMap.containsKey(node.hashCode())){
            //如果是复制主节点，还需要注入随机节点
            return preCreateMap.get(node.hashCode());
        }
        //创建拷贝节点
        RandomListNode copyTmp = new RandomListNode(node.label);
        preCreateMap.put(node.hashCode(), copyTmp);
        return copyTmp;
    }

    public static void main(String[] args) {
        RandomListNode listNode1 = new RandomListNode(1);
        RandomListNode listNode2 = new RandomListNode(2);
        RandomListNode listNode3 = new RandomListNode(3);
        listNode1.next = listNode2;
        listNode1.random = listNode3;
        listNode2.next = listNode3;
        listNode2.random = listNode1;
        listNode3.random = listNode2;
        ComplicatedLinkCopy complicatedLinkCopy = new ComplicatedLinkCopy();
        complicatedLinkCopy.clone(listNode1);
    }
}

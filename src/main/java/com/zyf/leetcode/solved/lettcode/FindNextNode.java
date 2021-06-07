package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: FindNextNode.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉树的下一个结点
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 * @Author: Administrator
 * @Date: 2021/6/4 18:19
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindNextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //如果右节点不为null，则下一节点为右节点的最左侧节点
        TreeLinkNode right;
        if((right = pNode.right) !=null){
            while (right.left!=null){
                right = right.left;
            }
            return right;
        }else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode){
                    return parent;
                }
                    
                pNode = pNode.next;
            }
        }
        return null;
    }
    
}

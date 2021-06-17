package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: SearchTree.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
 * @Author: Administrator
 * @Date: 2021/6/16 18:09
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SearchTree {

    /**
     * 头指针
     */
    private TreeNode head = null;
    /**
     * 当前尾节点
     */
    private TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {

        changeTree(pRootOfTree);
        return head;
    }
    
    
    private void changeTree(TreeNode pRootOfTree){
        //中序遍历
        if(pRootOfTree == null){
            return;
        }
        changeTree(pRootOfTree.left);
        
        if(pre == null){
            pre = pRootOfTree;
            head = pre;
        }else{
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }

        changeTree(pRootOfTree.right);
    }
}

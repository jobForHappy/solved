package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: FindK.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉搜索树的第k个结点
 * @Author: Administrator
 * @Date: 2021/6/17 17:57
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindK {
    
    private int current;

    TreeNode KthNode(TreeNode pRoot, int k) {
        current = k;
        return doFind(pRoot);
    }
    
    private TreeNode doFind(TreeNode pRoot){
        if(pRoot == null){
            return null;
        }
        TreeNode treeNode = doFind(pRoot.left);
        if(treeNode!=null){
            return treeNode;
        }
        if(--current == 0){
            return pRoot;
        }
        return doFind(pRoot.right);
    }
}

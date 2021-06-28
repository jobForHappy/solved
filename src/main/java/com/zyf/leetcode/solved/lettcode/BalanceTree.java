package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: BalanceTree.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 平衡二叉树
 * @Author: Administrator
 * @Date: 2021/6/18 18:16
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class BalanceTree {
    
    Boolean result = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return result;
        }
        judge(root);
        return result;
    }
    
    private void judge(TreeNode root){
        //获取左深度
        int left = getDepth(root.left);
        //获取右深度
        int right = getDepth(root.right);
        if(Math.abs(left-right)>1){
            result = false;
            return ;
        }
        
        if(root.left!=null){
            judge(root.left);
        }
        if(root.right!=null){
            judge(root.right);
        }
    }
    
    private int getDepth(TreeNode root){
        return root==null?0:1+Math.max(getDepth(root.right), getDepth(root.left));
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.util.HashMap;

/**
 * @Title: RebuildTree.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入：
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 复制
 * 返回值：
 * {1,2,5,3,4,6,7}
 * @Author: Administrator
 * @Date: 2021/6/3 17:56
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RebuildTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //用来存放中遍历的值与索引对应关系
        HashMap<Integer, Integer> inMap = new HashMap((int)(in.length/0.75f));
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        return getTreeNode(pre, in, inMap);

    }

    private TreeNode getTreeNode(int[] pre, int[] in, HashMap<Integer, Integer> inMap) {
        
        //左节点范围
        Integer leftRange = inMap.get(pre[0]);
        //获取左节点范围值
        int[] leftPre = new int[leftRange];
        int[] leftIn = new int[leftRange];
        System.arraycopy(pre, 0, leftPre, 0, leftRange);
        System.arraycopy(in, 0, leftIn, 0, leftRange);

        int[] rightPre = new int[pre.length-leftRange];
        int[] rightIn = new int[pre.length-leftRange];
        System.arraycopy(pre, leftRange, rightPre, 0, pre.length-leftRange);
        System.arraycopy(in, leftRange, rightIn, 0, pre.length-leftRange);

        TreeNode treeNode = new TreeNode(pre[0]);
        treeNode.left = reConstructBinaryTree(leftPre,leftIn);
        treeNode.right = reConstructBinaryTree(rightPre,rightIn);
        return treeNode;
    }
}

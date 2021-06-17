package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: TargetRoute.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉树中和为某一值的路径
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @Author: Administrator
 * @Date: 2021/6/15 18:38
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class TargetRoute {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getTarget(root, target, result, new ArrayList<>());
        return result;
    }

    private void getTarget(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp) {
        if(root == null){
            return;
        }
        tmp.add(root.val);
        if (target - root.val == 0 && root.left==null && root.right==null) {
            result.add(tmp);
            return;
        }

        if (target - root.val < 0) {
            return;
        }
        
        getTarget(root.left, target-root.val, result, new ArrayList(tmp));
        getTarget(root.right, target-root.val, result, new ArrayList(tmp));
    }
}

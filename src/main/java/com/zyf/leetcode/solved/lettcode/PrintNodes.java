package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: PrintNodes.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 从上往下打印二叉树
 * @Author: Administrator
 * @Date: 2021/6/9 18:36
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class PrintNodes {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        List<TreeNode> treeNodes = Arrays.asList(root);
        while (true){
            treeNodes = getTreeNodes(treeNodes, result);
            if(treeNodes.size()<0){
                return result;
            }
        }
    }

    private List<TreeNode> getTreeNodes(List<TreeNode> nodes, List<Integer> result){
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).left!=null){
                list.add(nodes.get(i).left);
            }
            if(nodes.get(i).right!=null){
                list.add(nodes.get(i).right);
            }

            result.add(nodes.get(i).val);

        }

        return list;
    }
}

package com.zyf.leetcode.solved.lettcode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: degreeOfDepth.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @Author: Administrator
 * @Date: 2021/6/17 18:28
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class DegreeOfDepth {
    
    private int depth;

    public int TreeDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }

        doGet(new ArrayList(Arrays.asList(root)));
        return depth;
    }
    
    private void doGet(List<TreeNode> list){
        if(list.size()<1){
            return;
        }
        
        List<TreeNode> tmp = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)!=null){
                if(list.get(i).left!=null){
                    tmp.add(list.get(i).left);
                }
                if(list.get(i).right!=null){
                    tmp.add(list.get(i).right);
                }
                
            }
            
        }

        depth++;
        doGet(tmp);
        
    }
}

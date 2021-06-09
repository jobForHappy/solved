package com.zyf.leetcode.solved.lettcode;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: SymmetryTree.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 对称的二叉树
 * 描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 示例1
 * 输入：
 * {8,6,6,5,7,7,5}
 * 复制
 * 返回值：
 * true
 * @Author: Administrator
 * @Date: 2021/6/8 18:18
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SymmetryTree {

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return judge(pRoot.left, pRoot.right);
    }
    
    public Boolean judge(TreeNode node1, TreeNode node2){
        
        if(node1 == null && node2== null){
            return true;
        }
        
        if(node1 == null || node2==null){
            return false;
        }
        
        if(node1.val != node2.val){
            return false;
        }
        
        return judge(node1.left, node2.right)&&judge(node1.right, node2.left);
    }
    
/*    boolean isSymmetrical(TreeNode pRoot) {
        List<TreeNode> treeNodes = Arrays.asList(pRoot);
        while (true){
            //对树的每一层的数据进行判断
            treeNodes = getTreeNodes(treeNodes);

            //如果为空，则表示对比完成
            if(treeNodes.size() == 0){
                return true;
            }

            //判断当前层的数据是否对称,如果不对称，返回false，否则比较下一层
            if(!judge(treeNodes)){
                return false;
            }
        }
        
    }
    
    private List<TreeNode> getTreeNodes(List<TreeNode> nodes){
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).left!=null){
                list.add(nodes.get(i).left);
            }
            if(nodes.get(i).right!=null){
                list.add(nodes.get(i).right);
            }
            
        }
        
        return list;
    }
    
    private boolean judge(List<TreeNode> treeNodes){
        //不为双数，肯定不对称
        if(treeNodes.size()%2 != 0){
            return false;
        }
        int left = (treeNodes.size() / 2)-1;
        int right = treeNodes.size() / 2;
        while (left>=0){
            if(treeNodes.get(left).val!=treeNodes.get(right).val){
                return false;
            }
            left--;
            right++;
        }
        
        return true;
    }*/
    
}

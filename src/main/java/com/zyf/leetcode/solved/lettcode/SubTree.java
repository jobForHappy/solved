package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: SubTree.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 树的子结构
 * 描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 示例1
 * 输入：
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * 复制
 * 返回值：
 * true
 * @Author: Administrator
 * @Date: 2021/6/8 17:32
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SubTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        
        if(root1.val == root2.val){
            //判断其他的节点是否相等
            if(judge(root1, root2)){
                return true;
            }
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    
    
    private boolean judge(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        
        if(root1==null){
            return false;
        }
        
        
        if(root1.val == root2.val){
            return judge(root1.left, root2.left)&&judge(root1.right, root2.right);
        }
        
        return false;
    }
}

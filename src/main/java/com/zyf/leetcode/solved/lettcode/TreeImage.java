package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: TreeImage.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉树的镜像
 * @Author: Administrator
 * @Date: 2021/6/8 17:56
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class TreeImage {

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return pRoot;
        }

        TreeNode left = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = left;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        
        return pRoot;
    }
}

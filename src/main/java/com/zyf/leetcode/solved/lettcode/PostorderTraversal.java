package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: PostorderTraversal.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉搜索树的后序遍历序列
 * @Author: Administrator
 * @Date: 2021/6/11 18:10
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class PostorderTraversal {

    public boolean VerifySquenceOfBST(int [] sequence) {
        return verification(sequence, 0, sequence.length-1);
    }
    
    private Boolean verification(int [] sequence, int start, int root){

        if(start >= root){
            return true;
        }
        
        //获取root节点
        int rootValue = sequence[root];
        int  cutOffPoint = 0;
        //获取root节点的左右节点分界点
        for (int i = start; i < root; i++) {
            if(sequence[i]>rootValue){
                cutOffPoint = i;
                break;
            }
        }
        
        //判断右边的节点是否都小于根节点,如果小于，则不合理
        for (int j = (cutOffPoint+1); j < root; j++) {
            if(sequence[j]<rootValue){
                return false;
            }
        }
        
        return verification(sequence, start, cutOffPoint-1) && verification(sequence, cutOffPoint, root-1);
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title: FullPermutation.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 全排列
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 * @Author: Administrator
 * @Date: 2021/3/1 18:14
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FullPermutation2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finaResult= new ArrayList<>();
        List result = new ArrayList();
        List<Integer> haveUsedIndex = new ArrayList<>();
        iteration(nums,1, result,haveUsedIndex, finaResult);
        return finaResult;
    }

    private void iteration(int[] nums, int index, List result, List<Integer> haveUsedIndex, List<List<Integer>> finaResult) {
        for (int i = 0; i < nums.length; i++) {
            if (haveUsedIndex.contains(i)) {
                continue;
            }
            List tmp = new ArrayList();
            List<Integer> haveUsedIndexTmp = new ArrayList();
            tmp.addAll(result);
            tmp.add(nums[i]);
            haveUsedIndexTmp.addAll(haveUsedIndex);
            haveUsedIndexTmp.add(i);
            if (index >= nums.length) {
                if(!finaResult.contains(tmp)){
                    finaResult.add(tmp);    
                }
            } else {
                iteration(nums, index+1, tmp, haveUsedIndexTmp, finaResult);
            }
        }
    }

    public static void main(String[] args) {
        
        int[] nums = new int[]{1,1,3};
        FullPermutation2 fl = new FullPermutation2();
        fl.permute(nums);
    }
}

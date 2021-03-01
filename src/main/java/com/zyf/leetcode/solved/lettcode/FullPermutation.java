package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: FullPermutation.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Administrator
 * @Date: 2021/3/1 18:14
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FullPermutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finaResult= new ArrayList<>();
        List result = new ArrayList();
        iteration(nums,1, result, finaResult);
        return finaResult;
    }

    private void iteration(int[] nums, int index, List result, List<List<Integer>> finaResult) {
        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])) {
                continue;
            }
            List tmp = new ArrayList();
            tmp.addAll(result);
            tmp.add(nums[i]);
            if (index >= nums.length) {
                finaResult.add(tmp);
            } else {
                iteration(nums, index+1, tmp, finaResult);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        FullPermutation fl = new FullPermutation();
        fl.permute(nums);
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: totalTwo.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 总和2
 * @Author: Administrator
 * @Date: 2021/1/20 18:17
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class TotalTwo {

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param candidates 数组
     * @param target 目标值
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        caculate(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 
     * @param candidates 数组
     * @param target 目标值
     * @param current 当前和
     * @param index 当前下标
     */
    private Boolean caculate(int[] candidates, int target, int current, int index, List<Integer> currentList, List<List<Integer>> result){
        
        if(current>target){
            return true;
        }
        
        if(current == target){
            result.add(currentList);
            return true;
        }
        
        for (int i = index; i < candidates.length; i++) {
            
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }
            
            if(current+candidates[i]>target){
                break;
            }
            
            ArrayList<Integer> integers = new ArrayList<>(currentList);
            integers.add(candidates[i]);
            if(caculate(candidates, target, current+candidates[i], i+1, integers, result)){
             break;   
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        TotalTwo solution = new TotalTwo();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
    }
}

package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: MaxSubsequenceCoun.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Administrator
 * @Date: 2021/3/18 18:24
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MaxSubsequenceCount {
    public int maxSubArray(int[] nums) {
        return calculate(nums, 0, null);
    }
    
    private int calculate(int[] nums, int index, Integer currentCount){
        if(index == nums.length){
            return currentCount;
        }
        
        int tmp = 0;
        for (int i = index; i < nums.length; i++) {
            tmp += nums[i];
            if( currentCount == null|| tmp>currentCount){
                currentCount = tmp;
                continue;
            }
        }
        

        return calculate(nums, ++index, currentCount);
    }
}

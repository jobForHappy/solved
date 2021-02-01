package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: AbsentInteger.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 缺失的正整数
 * @Author: Administrator
 * @Date: 2021/1/22 18:17
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 
 * 提示：
 *
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AbsentInteger {

    public int firstMissingPositive(int[] nums) {
        if(nums ==null || nums.length == 0){
            return 1;
        }
        //将数组中不在1到nums.length之间的数字变为nums.length+1，因为他不可能小于缺失的那个正整数（缺失的正整数只会在1到nums.length之间）
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>nums.length || nums[i]<=0){
                nums[i] = nums.length+1;
            }
        }

        for (int i = 0; i < nums.length; i++){
            int abs = Math.abs(nums[i]);
            if (0 < abs && abs <= nums.length) {
                if(nums[abs-1]>0){
                    nums[abs-1] = - Math.abs(nums[abs-1]);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                return i+1;
            }
        }
        
        return nums.length+1;
    }
}

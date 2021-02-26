package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: SkipGame.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @Author: 张云飞
 * @Date: 2021/2/25 18:27
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SkipGame {
    public int jump(int[] nums) {

        int ans = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length)
        {
            int maxPos = 0;
            for (int i = start; i < end; i++)
            {
                // 能跳到最远的距离
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;      // 下一次起跳点范围开始的格子
            end = maxPos + 1; // 下一次起跳点范围结束的格子
            ans++;            // 跳跃次数
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 2;
        nums[1] = 5;
        nums[2] = 1;
        SkipGame sd = new SkipGame();
        sd.jump(nums);
    }
}

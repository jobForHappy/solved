package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: RepeatNum.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Administrator
 * @Date: 2021/4/28 16:31
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RepeatNum {

    public int findRepeatNumber(int[] nums) {
        //当前下标
        int index = 0;
        //当前次数
        int count = 1;
        while(count<=nums.length){
            //取当前值
            int tmp = nums[index];
            
            if(tmp==index){
                count++;
                continue;
            }
            //放入到对应下标桶位
            //如果对应下标中的数字与桶索引相等，说明重复
            if(nums[tmp] == tmp ){
                return tmp;
            }
            index = nums[tmp];
            nums[tmp] = tmp;
            count++;
        }
        
        return -1;
    }
}

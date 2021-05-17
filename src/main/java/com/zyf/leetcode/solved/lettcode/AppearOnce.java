package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title: AppearOnce.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 只出现一次
 * @Author: Administrator
 * @Date: 2021/4/1 17:45
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class AppearOnce {

    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                list.remove(Integer.valueOf(nums[i]));
            }else{
                list.add(nums[i]);   
            }
            
        }
        return list.get(0);
    }
}

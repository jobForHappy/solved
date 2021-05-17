package com.zyf.leetcode.solved.lettcode;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: MostNumber.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 多数元素
 * @Author: Administrator
 * @Date: 2021/4/1 18:06
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MostNumber {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap(nums.length/2);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]).intValue()+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        AtomicInteger result = new AtomicInteger();
        map.forEach((key, value)->{
            if(value>nums.length/2){
                result.set(key);
            }
        });
        return result.get();
    }

    public static void main(String[] args) {
        MostNumber mostNumber = new MostNumber();
        int[] nums = new int[] {1, 2, 3};
        mostNumber.majorityElement(nums);
    }
}

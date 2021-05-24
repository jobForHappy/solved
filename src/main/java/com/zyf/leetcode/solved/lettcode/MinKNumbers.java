package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Title: MinKNumbers.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 最小k个数
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * 示例1
 * 输入
 * 复制
 * [4,5,1,6,2,7,3,8],4 
 * 返回值
 * 复制
 * [1,2,3,4]
 * @Author: Administrator
 * @Date: 2021/5/20 18:29
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MinKNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        //使用优先级队列存储数组
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            maxHeap.add(input[i]);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        
        return new ArrayList<>(maxHeap);
    }
}

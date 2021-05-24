package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Title: FindMaxInRang.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 滑动窗口最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 * @Author: Administrator
 * @Date: 2021/5/24 17:18
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindMaxInRang {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        //用来存放当前窗口值，并且大的值放在前面
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> o2 - o1);
        //结果
        ArrayList<Integer> res = new ArrayList<>();
        
        if(size<1 || size>num.length){
            return res;
        }

        //放入窗口大小的元素
        for (int i = 0; i < size; i++) {
            pq.add(num[i]);
        }
        //放入前三个的最大值
        res.add(pq.peek());
        
        //滑动窗口
        for (int j=0, i = j+size; i < num.length; j++, i++) {
            pq.remove(num[j]);
            pq.add(num[i]);
            res.add(pq.peek());
        }
        
        return res;
    }
}

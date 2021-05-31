package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;

/**
 * @Title: ContinuouslyTargetSum.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @Author: Administrator
 * @Date: 2021/5/25 15:13
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class ContinuouslyTargetSum {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        int frontIndex = 1;
        int behindIndex = 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int currentSum = 3;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(frontIndex);
        tmp.add(behindIndex);
        while (frontIndex < behindIndex) {
            //如果小于，则移动后索引,多加一个数进来
            if (currentSum < sum) {
                behindIndex++;
                currentSum += behindIndex;
                tmp.add(behindIndex);
            } else if (currentSum > sum) {
                //如果小于，则移动前索引,去掉一个数
                tmp.remove(Integer.valueOf(frontIndex));
                currentSum -= frontIndex;
                frontIndex++;
                
            } else {
                res.add(new ArrayList<>(tmp));
                currentSum-=frontIndex;
                tmp.remove(Integer.valueOf(frontIndex));
                behindIndex++;
                frontIndex++;
                currentSum+= behindIndex;
                tmp.add(behindIndex);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        ContinuouslyTargetSum continuouslyTargetSum = new ContinuouslyTargetSum();
        continuouslyTargetSum.FindContinuousSequence(9);
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: FindSpecifySum.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 查找指定和
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @Author: Administrator
 * @Date: 2021/5/25 14:59
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindSpecifySum {

    
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int frontIndex = 0;
        int behindIndex = array.length - 1;
        while (frontIndex < behindIndex) {
            if(array[frontIndex]+array[behindIndex]>sum){
                behindIndex--;
            }else if(array[frontIndex]+array[behindIndex]<sum){
                frontIndex++;
            }else{
                res.add(array[frontIndex]);
                res.add(array[behindIndex]);
                return res;
            }
        }
        return res;
        
    }
}

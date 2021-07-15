package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: AdjustArray.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 示例1
 * 输入：
 * [1,2,3,4]
 * 复制
 * 返回值：
 * [1,3,2,4]
 * 复制
 * 示例2
 * 输入：
 * [2,4,6,5,7]
 * 复制
 * 返回值：
 * [5,7,2,4,6]
 * @Author: Administrator
 * @Date: 2021/7/1 18:41
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class AdjustArray {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        int[] copy = new int[array.length];
        int evenIndex = 0;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2!=0){
                copy[evenIndex] = array[i];
                evenIndex++;
            }else{
                tmp.add(array[i]);
            }
        }

        for (int i = 0; i < tmp.size(); i++) {
            copy[evenIndex] = tmp.get(i);
            evenIndex++;
        }
        
        return copy;
    }
}

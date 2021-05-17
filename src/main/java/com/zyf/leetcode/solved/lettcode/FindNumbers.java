package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: FindNumbers.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二维数组中的查找
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 * @Author: Administrator
 * @Date: 2021/5/17 16:32
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindNumbers {
    
    public boolean getNumber(int[][] array, int target){
        int i = array.length-1;
        int j = 0;
        while(i>=0&&j<array[0].length){
            if(array[i][j] > target){
                i--;
            }else if(array[i][j] < target){
                j++;
            }else if(array[i][j] == target){
                return true;
            }
        }
        
        return false;
    }
    
    
}

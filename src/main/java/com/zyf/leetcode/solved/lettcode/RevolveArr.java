package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: RevolveArr.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 旋转数组
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入：
 * [3,4,5,1,2]
 * 复制
 * 返回值：
 * 1
 * @Author: Administrator
 * @Date: 2021/6/24 16:56
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RevolveArr {

    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            
        }
        return getMin(array, 0, array.length-1, array[array.length-1]);
        
    }
    
    private int getMin(int [] array, int startIndex, int endIndex, int target){
        
        if(array[startIndex]<array[endIndex]){
            return array[startIndex];
        }
        int currentIndex = (endIndex - startIndex)/2;
        if(startIndex>=target){
            return array[endIndex];
        }
        
        if(array[currentIndex+startIndex]>target){
            return getMin(array, currentIndex+1, endIndex, target);
        }else if(array[currentIndex+startIndex]<target){
            return getMin(array, startIndex, currentIndex+startIndex, target);
        }
        
        return 0;
    }
}

package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: BuildProductArr.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 示例1
 * 输入：
 * [1,2,3,4,5]
 * 复制
 * 返回值：
 * [120,60,40,30,24]
 * 不能用除法
 * @Author: Administrator
 * @Date: 2021/7/15 17:32
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class BuildProductArr {

    /**
     * 分析：
     * b[i] = left[i]*right[i]
     * left[i] = left[i-1]*A[i]
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        //定义一个数组，来算left[i]的值
        int[] left = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i-1]*A[i-1];
        }
        //计算右边的值
        //最后一个b[i]的最右边值为1（因为他排除的就是最后一个数，所以他没有right，可以看做right=1）
        int right = 1;
        for (int i = A.length-2; i >=0; --i) {
            //求出B[i]的右边值  从后往推，每推一次，就是用上一个右边值*乘以上一个缺失的值
            right = right*A[i+1];
            //计算b[i],直接用left[i]来保存b[i]
            left[i]*= right;
            
        }
        
        return left;
    }
}

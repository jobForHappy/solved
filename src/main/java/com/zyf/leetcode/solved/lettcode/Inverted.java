package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: Inverted.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 对于50\%50%的数据,size\leq 10^4size≤10
 * 4
 * <p>
 * 对于100\%100%的数据,size\leq 10^5size≤10
 * 5
 * <p>
 * <p>
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 * 示例1
 * 输入：
 * [1,2,3,4,5,6,7,0]
 * 复制
 * 返回值：
 * 7
 * @Author: Administrator
 * @Date: 2021/7/2 17:39
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class Inverted {

    int[] tmp;

    public int InversePairs(int[] array) {
        tmp = new int[array.length];
        doGet(array, 0, array.length - 1);
        return 0;
    }

    private void doGet(int[] array, int left, int right) {

        //退出条件
        if (right - left < 1) {
            return;
        }

        //分治
        int mid = left + (right - left) / 2;
        doGet(array, left, mid);
        doGet(array, mid + 1, right);

        //合并
        merge(array, left, mid, right);
    }

    /**
     * 从大到小合并
     *
     * @param array
     * @param mid
     * @param left
     * @param right
     */
    private void merge(int[] array, int mid, int left, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tmpIndex = left;
        while (leftIndex <= mid || rightIndex <= right) {
            //左边的遍历完了，直接把右边的按序放入
            if (leftIndex > mid) {
                tmp[tmpIndex] = array[rightIndex++];
            } else if (rightIndex > right) {
                tmp[tmpIndex] = array[leftIndex++];
            } else if (array[leftIndex] <= array[rightIndex]) {
                tmp[tmpIndex] = array[leftIndex++];
            } else {
                //计算个数
                tmp[tmpIndex] = array[rightIndex];
            }

            tmpIndex++;
        }
    }

}

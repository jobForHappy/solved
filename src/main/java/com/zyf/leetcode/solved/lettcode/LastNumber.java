package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: LastNumber.java
 * @Package com.zyf.leetcode.solved.lettcode
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Description: 最后一个数字
 * @Author: Administrator
 * @Date: 2021/4/20 18:15
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class LastNumber {

    public int lastRemaining(int n, int m) {

        if(n == 1){
            return 0;
        }
        
        //但n取不同的值时所剩下的数字的下标
        int currentIndex = 0;
        for (int i = 2; i <= n; i++) {
            currentIndex = (currentIndex+m)%i;
        }
        return currentIndex;
    }
    
}

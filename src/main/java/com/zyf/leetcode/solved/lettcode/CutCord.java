package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: CutCord.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description:
 * @Author: Administrator
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述：
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 返回值描述：
 * 输出答案。
 * 示例1
 * 输入：
 * 8
 * 复制
 * 返回值：
 * 18
 * @Date: 2021/6/23 16:06
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class CutCord {
    public int cutRope(int target) {

        //因为至少两段，所以低于4时，需要单独考虑拆分为两段的值
        if(target == 3){
            return 2;
        }
        
        if(target == 2){
            return 1;
        }

        //定义一个数组用来存储中间值
        int[] tmp = new int[target+1];
        return calculate(target, tmp);
    }
    
    private int calculate(int target, int[] tmp){
        //退出条件
        if(target<=4){
            return target;
        }
        
        if(tmp[target] != 0){
            return tmp[target];
        }

        //穷举法，走遍所有可能的情况，然后返回最大值
        int max = 0;
        for (int i = 1; i < target; ++i) {
            max = Math.max(max, i*calculate(target-i, tmp));
        }

        tmp[target] = max;
        return max;
    }
    
}

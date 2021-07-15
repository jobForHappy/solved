package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: frogSkip.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 跳台阶
 * @Author: Administrator
 * @Date: 2021/7/8 17:56
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FrogSkip {
    public int jumpFloorII(int target) {
        if (target<=2) {
            return target;
        }
        //f(n-1)
        int front = 2;
        for (int i = 3; i <= target; i++) {
            front = 2*front ;

        }

        return front;
    }
}

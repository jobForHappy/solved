package com.zyf.leetcode.solved.lettcode;

import java.security.SecureRandom;
import java.util.BitSet;
import java.util.Random;
import java.util.function.IntConsumer;

/**
 * @Title: SortedByBitSet.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 排序
 * @Author: Administrator
 * @Date: 2021/4/20 16:18
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SortedByBitSet {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(1001);
        for (int i = 0; i < 100; i++) {
            SecureRandom random = new SecureRandom();
            int i1 = random.nextInt(1000) ;
            bitSet.set(i1);
        }

        for (int i = 0; i < 100; i++) {
            if(bitSet.get(i)){
                System.out.println(i);
            }
        }
    }

    
}

package com.zyf.leetcode.solved.lettcode;

import java.util.PriorityQueue;

/**
 * @Title: Median.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 得到一个数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @Author: Administrator
 * @Date: 2021/5/21 16:21
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class Median {
    
    
    /**
     * 左队列
     */
    PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);
    /**
     * 右队列
     */
    PriorityQueue<Integer> right = new PriorityQueue();
    /**
     * 数量
     */
    int index;

    public void Insert(Integer num) {
        //偶个数放在右边
        if((++index)%2 == 0){
            left.add(num);
            right.add(left.poll());
        }else{
            right.add(num);
            left.add(right.poll());
        }
    }

    public Double GetMedian() {
        if(index%2==0){
            return (left.peek()+right.peek())/2.0;
        }else{
            return Double.valueOf(right.peek());
        }
    }
}

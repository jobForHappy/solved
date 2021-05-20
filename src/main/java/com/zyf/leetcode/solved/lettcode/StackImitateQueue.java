package com.zyf.leetcode.solved.lettcode;

import java.util.Stack;

/**
 * @Title: StackImitateQueue.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * 栈：先进后出、队列先进先出
 * @Author: Administrator
 * @Date: 2021/5/18 17:45
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class StackImitateQueue {

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception{
        if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }

        
        if(out.isEmpty()){
            throw new Exception("queue is empty");
        }

        return out.pop();
    }
}

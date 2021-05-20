package com.zyf.leetcode.solved.lettcode;

import java.util.Stack;

/**
 * @Title: MinStrack.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 包含最小数的栈
 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
 * @Author: Administrator
 * @Date: 2021/5/20 16:00
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MinStack {
    
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int node){

        minStack.push(minStack.isEmpty() || minStack.peek()>node?node:minStack.peek());
        stack.push(node);
    }

    public int top() {
        return stack.peek();
    }
    
    public int pop(){
        minStack.pop();
        return stack.pop();
    }
    
    public int min(){
        return minStack.peek();
    }
}

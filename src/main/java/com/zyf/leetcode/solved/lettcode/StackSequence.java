package com.zyf.leetcode.solved.lettcode;

import java.util.Stack;

/**
 * @Title: StackSequence.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 * @Author: Administrator
 * @Date: 2021/5/20 18:02
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class StackSequence {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0, index = 0; i < pushA.length; i++) {
            //将数字压入栈中
            stack.push(pushA[i]);
            //比较栈顶元素是否和出栈顺序数组中当前的数字相同，如果相同，则出栈(相当于按照popA进行出栈操作)
            while (!stack.isEmpty()&&stack.peek() == popA[index]){
                stack.pop();
                index++;
            }
        }
        
        return stack.isEmpty();
    }
}

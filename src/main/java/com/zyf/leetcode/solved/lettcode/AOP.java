package com.zyf.leetcode.solved.lettcode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Title: AOP.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 动态代理
 * @Author: Administrator
 * @Date: 2021/4/21 11:37
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class AOP {
    
    static class MyHand implements InvocationHandler {

        private Object obj;
        
        MyHand(Object obj){
            this.obj = obj;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理前置处理器");
            Object invoke = method.invoke(obj,args);
            System.out.println("代理后置处理器");
            return invoke;
        }
    }
    
    
     interface Deal{
        
        void sayHello();
    }
    
    static class ddl implements Deal{

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        Deal deal = new ddl();
        MyHand myHand = new MyHand(deal);
        Deal o = (Deal)Proxy.newProxyInstance(Deal.class.getClassLoader(), new Class[] {Deal.class}, myHand);
        o.sayHello();
    }
    
}

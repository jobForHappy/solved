package com.zyf.leetcode.solved.lettcode;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Title: MyInvocation.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description:
 * @Author: Administrator
 * @Date: 2021/6/11 17:26
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MyInvocation implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("发送短信前");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("发送短信后");
        return invoke;
    }
}

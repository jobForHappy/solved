package com.zyf.leetcode.solved.lettcode;

import net.sf.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @Title: ProxyFactory.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description:
 * @Author: Administrator
 * @Date: 2021/6/11 17:25
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class ProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MyInvocation());
        return enhancer.create();
    }
}

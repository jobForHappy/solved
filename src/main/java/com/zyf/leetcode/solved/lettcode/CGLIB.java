package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: CGLIB.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 动态代理
 * @Author: Administrator
 * @Date: 2021/6/11 16:57
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class CGLIB {
    
    public static void main(String[] args) {
        SendMail proxy = (SendMail)ProxyFactory.getProxy(SendMail.class);
        proxy.send("发送短信");
    }

}

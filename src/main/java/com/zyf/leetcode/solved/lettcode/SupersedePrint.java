package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: supersedePrint.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 交替打印0到100
 * @Author: Administrator
 * @Date: 2021/4/16 17:22
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SupersedePrint {
    
    private static int number = 1;

    static class print1 implements Runnable{
        
        @Override
        public void run(){
            while(number<=100){
                if(number%2==0){
                    System.out.println(number+Thread.currentThread().getName());
                    number++;
                }
            }
        }
    }
    
    static class print2 implements Runnable{
        
        @Override
        public void run(){
            while (number<=100){
                if(number%2!=0){
                    System.out.println(number+Thread.currentThread().getName());
                    number++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        new Thread(new print1(), "thread one").start();
        new Thread(new print2(), "thread two").start();
        
    }
}

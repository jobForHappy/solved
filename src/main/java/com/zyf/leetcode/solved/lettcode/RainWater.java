package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: RainWater.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 接雨水
 * @Author: Administrator
 * @Date: 2021/2/1 17:48
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class RainWater {
    public int trap(int[] height) {

        int result = 0;

        if(height == null || height.length == 0){
            return result;
        }
        
        //当前排在第一个的有效桶的高度
        int currentFirst = 0;
        //第一个有效桶的索引
        int index = 0;
        
        //找到第一个有效桶
        for (int i = 0; i < height.length; i++) {
            if(height[i]>0){
                currentFirst = height[i];
                index = i;
                break;
            }
        }
        
        if(currentFirst<=0){
            return result;
        }

        //面积长度
        int with = 1;
        //桶占的面积
        int bulkNumber = currentFirst;
        for (int i = (index+1); i < height.length; i++) {
            with+=1;
            if(height[i]>currentFirst){
                bulkNumber+=(currentFirst);
            }else if(height[i]>0){
                bulkNumber+=height[i];
            }
            if(height[i]>=currentFirst && with>=2){
                //计算面积
                result = result+(with*currentFirst)-bulkNumber;
                //重新开始计算周期
                currentFirst = height[i];
                bulkNumber = currentFirst;
                with = 1;
                index = i;
            }
            
            //如果到最后还没有找到大于等于
            if(i == height.length-1 && index!=i){
                bulkNumber = currentFirst-=1;
                i = index;
                with = 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[9];
        height[0] = 0;
        height[1] = 0;
        height[2] = 0;
        height[3] = 2;
        height[4] = 0;
        height[5] = 8;
        height[6] = 6;
        height[7] = 7;
        height[8] = 7;

        RainWater rw = new RainWater();
        rw.trap(height);
    }
}

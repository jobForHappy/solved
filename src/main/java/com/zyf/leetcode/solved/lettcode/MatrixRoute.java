package com.zyf.leetcode.solved.lettcode;

import java.util.HashMap;

/**
 * @Title: MatrixRoute.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 矩阵中的路径
 * 描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad 
 * ⎣
 * ⎡
 * ​	
 *
 * a
 * s
 * a
 * ​	
 *
 * b
 * f
 * d
 * ​	
 *
 * c
 * c
 * e
 * ​	
 *
 * e
 * s
 * e
 * ​	
 *
 * ⎦
 * ⎤
 * ​	
 *   矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 示例1
 * 输入：
 * "ABCESFCSADEE",3,4,"ABCCED"
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * "ABCESFCSADEE",3,4,"ABCB"
 * 复制
 * 返回值：
 * false
 * @Author: Administrator
 * @Date: 2021/6/30 17:14
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MatrixRoute {

    Boolean result = false;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix string字符串 
     * @param rows int整型 
     * @param cols int整型 
     * @param str string字符串 
     * @return bool布尔型
     */
    public boolean hasPath (String matrix, int rows, int cols, String str) {

        char[] chars = matrix.toCharArray();
        int index = 0;
        //先将字符串变为数组
        String[][] ad = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ad[i][j] = String.valueOf(chars[index]);
                index++;
            }
        }

        search(ad, str);
        
        
        return result;
    }
    
    private void search(String[][] ad, String str){
        HashMap<String, Integer> hashMap = new HashMap<>(25);
        //找到开头的地方
        for (int i = 0; i < ad.length; i++) {
            for (int j = 0; j < ad[i].length; j++) {
                if(String.valueOf(str.charAt(0)).equals(ad[i][j])){
                    if(str.length() == 1){
                        result = true;
                        return;
                    }
                    //开始进行回溯查找
                    hashMap.put(i +"-"+ j, 1);
                    recall(ad, str.substring(1), i, j, hashMap);
                    if(result){
                        return;
                    }
                    
                    hashMap.remove(i +"-"+ j);
                }
            }
        }
    }
    
    private void recall(String[][] ad, String str, int rows, int cols, HashMap<String, Integer> hashMap){
        
        //前
        if(cols-1 >=0 && !hashMap.containsKey(rows +"-"+ (cols-1)) && ad[rows][cols-1].equals(String.valueOf(str.charAt(0)))){
            //如果相等，且未最后一个数，则对比成功，存在
            if(str.length() == 1){
                result = true;
                return;
            }
            
            hashMap.put(rows +"-"+ (cols-1), 1);
            recall(ad, str.substring(1), rows, cols-1, hashMap);
            if(result){
                return;
            }
            hashMap.remove(rows +"-"+ (cols-1));
        }
        
        //后
        if(cols+1 < ad[0].length && !hashMap.containsKey(rows +"-"+ (cols+1)) && ad[rows][cols+1].equals(String.valueOf(str.charAt(0)))){
            //如果相等，且未最后一个数，则对比成功，存在
            if(str.length() == 1){
                result = true;
                return;
            }
            
            hashMap.put(rows +"-"+ (cols+1), 1);
            recall(ad, str.substring(1), rows, cols+1, hashMap);
            if(result){
                return;
            }
            hashMap.remove(rows +"-"+ (cols+1));
        }
        
        //上
        if(rows-1 >= 0 && !hashMap.containsKey(rows-1 +"-"+ cols) && ad[rows-1][cols].equals(String.valueOf(str.charAt(0)))){
            //如果相等，且未最后一个数，则对比成功，存在
            if(str.length() == 1){
                result = true;
                return;
            }
            
            hashMap.put(rows-1 +"-"+ cols, 1);
            recall(ad, str.substring(1), rows-1, cols, hashMap);
            if(result){
                return;
            }
            hashMap.remove(rows-1 +"-"+ cols);
        }
        
        //下
        if(rows+1 < ad.length && !hashMap.containsKey(rows+1 +"-"+ cols) && ad[rows+1][cols].equals(String.valueOf(str.charAt(0)))){
            //如果相等，且未最后一个数，则对比成功，存在
            if(str.length() == 1){
                result = true;
                return;
            }
            
            hashMap.put(rows+1 +"-"+ cols, 1);
            recall(ad, str.substring(1), rows+1, cols, hashMap);
            if(result){
                return;
            }
            hashMap.remove(rows+1 +"-"+ cols);
        }
    }

    public static void main(String[] args) {
        MatrixRoute matrixRoute = new MatrixRoute();
        matrixRoute.hasPath("A",1,1,"A");
    }
}

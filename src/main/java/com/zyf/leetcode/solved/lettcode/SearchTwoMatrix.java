package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: SearchTwoMatrix.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 搜索二维矩阵
 * @Author: Administrator
 * @Date: 2021/4/1 18:29
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SearchTwoMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        return getY(0,0,matrix,target);
    }
    
    private Boolean getY(int x, int y, int[][] matrix, int target){
        for (int i = y; i < matrix[x].length; i++) {
            if(matrix[x][i]==target){
                return true;
            }
            if(matrix[x][i]>target){
                y = i-1;
                break;
            }
        }
        
        return getX(x, y, matrix, target);
    }
    
    private Boolean getX(int x, int y, int[][] matrix, int target){
        for (int i = y; i > 0; i--) {
            if(matrix[i][y]==target){
                return true;
            }
            if(matrix[i][y]>target){
                x = i-1;
                break;
            }
        }
        return getX(x, y, matrix, target);
    }
}

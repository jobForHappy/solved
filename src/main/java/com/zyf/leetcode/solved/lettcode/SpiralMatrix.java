package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: SpiralMatrix.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 螺旋矩阵
 * @Author: Administrator
 * @Date: 2021/3/22 18:04
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int xMin = 0;
        int xMax = matrix.length-1;
        int yMin = 0;
        int yMax = matrix[0].length-1;
        int direction = 3;
        List<Integer> result = new ArrayList<>();
        /**
         *
         * @param xMax 横向最大值
         * @param xMin 横向最小值
         * @param yMax 纵向最大值
         * @param yMin 纵向最大值
         * @param result 结果
         * @param direction 方向 上：0 下：1 左：2，右：3
         */
        while (true){
            switch (direction){
                case 0:
                    //向上
                    for (int i = xMax; i >=xMin; i--) {
                        result.add(matrix[i][yMin]);
                    }
                    
                    if(++yMin >yMax){
                        return result;
                    }
                    direction = 3;
                    break;

                case 1:
                    for (int i = xMin; i <= xMax; i++) {
                        result.add(matrix[i][yMax]);
                    }
                    if(--yMax <yMin){
                        return result;
                    }
                    direction = 2;
                    break;
                case 2:
                    for (int i = yMax; i >= yMin; i--) {
                        result.add(matrix[xMax][i]);
                    }
                    if(--xMax <xMin){
                        return result;
                    }
                    direction = 0;
                    break;
                case 3:
                    for (int i = yMin; i <= yMax; i++) {
                        result.add(matrix[xMin][i]);
                    }
                    if(++xMin >xMax){
                        return result;
                    }
                    direction = 1;
                    break;

                default:
                     return result;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        SpiralMatrix sp = new SpiralMatrix();
        sp.spiralOrder(matrix);
    }
    
}

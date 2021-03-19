package com.zyf.leetcode.solved.lettcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: Queen.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: q皇后
 * @Author: Administrator
 * @Date: 2021/3/16 18:00
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class Queen {

    public List<List<String>> solveNQueens(int n) {
        String[][] col = new String[n][n];
        List<String[][]> result = new ArrayList<>();
        deal(col, n-1, n-1, result);
        List<List<String>> finaResult = new ArrayList<>();
        //处理result
        for (int i = 0; i < result.size(); i++) {
            List<String> tmp = new ArrayList<>();
            String[][] strings = result.get(i);
            for (int j = 0; j < strings.length; j++) {
                tmp.add(Arrays.toString(strings[j]).replace("null", "").replace("[","").replace("]", "").replace(',', '.'));
            }
            finaResult.add(tmp);
        }
        return finaResult;
    }
    
    private void deal(String[][] col, int n, int max , List<String[][]> result){
        if(n<0){
            result.add(col);
            return;
        }
        for (int i = 0; i <= max; i++) {
            //判断同行
            String[] strings = col[n];
            if(Arrays.asList(strings).contains("Q")){
                if(i ==max){
                    return;
                }
                continue;
            }
            
            //判断竖
            Boolean have = false;
            for (int j = 0; j <= max; j++) {
                if("Q".equals(col[j][i])){
                    have = true;
                    break;
                }
            }
            
            if (have){
                if(i ==max){
                    return;
                }
                continue;
            }
            
            //判断斜的
            if ((n != max && i != max && "Q".equals(col[n + 1][i + 1])) || (n != max && i != 0 && "Q"
                .equals(col[n + 1][i - 1]))) {
                if(i ==max){
                    return;
                }
                continue;
            }

            String[][] clone = new String[max+1][max+1];
            for(int m = 0;m < col.length;m++) {
                System.arraycopy(col[m], 0, clone[m], 0, col[m].length);}

            clone[n][i] = "Q";
                deal(clone, n - 1, max, result);
            }
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.solveNQueens(4);
    }
}

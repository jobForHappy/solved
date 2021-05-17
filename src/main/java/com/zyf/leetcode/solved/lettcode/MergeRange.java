package com.zyf.leetcode.solved.lettcode;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: MergeRange.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Administrator
 * @Date: 2021/3/25 18:31
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MergeRange {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(current[1]>=interval[0]){
                current[1] = interval[1];
            }else{
                result.add(Arrays.copyOf(current, current.length));
                current = intervals[++i];
                if(i>= intervals.length){
                    result.add(Arrays.copyOf(current, current.length));
                }
            }
        }
        
        int[][] sr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            sr[i] = result.get(i);
        }
        return sr;
    }

    public static void main(String[] args) {
        File fileName = new File("http://");
        if(fileName.isFile()){
            System.out.println(fileName.getName());
        }
        if(fileName.isDirectory()){
            File[] files = fileName.listFiles();
            for (int i = 0; i < files.length; i++) {
                
            }
        }
    }
}

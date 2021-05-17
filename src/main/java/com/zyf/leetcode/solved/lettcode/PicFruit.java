package com.zyf.leetcode.solved.lettcode;

import java.util.HashMap;

/**
 * @Title: PicFruit.java
 * 
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 *
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 *
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 *
 * 用这个程序你能收集的水果树的最大总量是多少？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fruit-into-baskets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 摘水果
 * @Author: Administrator
 * @Date: 2021/4/12 18:01
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class PicFruit {

    public int totalFruit(int[] tree) {
        //定义第一个篮子
        HashMap<Integer, Integer> basketOne = new HashMap(2);
        //定义第二个篮子
        HashMap<Integer, Integer> basketSecond = new HashMap(2);
        //最大值
        int currentCount = 0;
        int maxCount = 0;
        //定义前指针
        int indexFirst = 0;
        int indexSecond = 0;

        for (int i = indexFirst; i < tree.length; i++) {
            //第一个包含就放第一个里面
            if(basketOne.containsKey(tree[i])){
                basketOne.put(tree[i], basketOne.get(tree[i]).intValue()+1);
                currentCount++;
                maxCount = Math.max(currentCount, maxCount);
            }else if(basketSecond.containsKey(tree[i])){
                //第二个包含就放第二个里面
                basketSecond.put(tree[i], basketSecond.get(tree[i]).intValue()+1);
                currentCount++;
                maxCount = Math.max(currentCount, maxCount);
            }else if(basketOne.isEmpty()){
                basketOne.put(tree[i], 1);
                currentCount++;
                maxCount = Math.max(currentCount, maxCount);
            }else if(basketSecond.isEmpty()){
                basketSecond.put(tree[i], 1);
                currentCount++;
                maxCount = Math.max(currentCount, maxCount);
            }else{
                for (int j = indexSecond; j < i; j++) {
                    //往前面清除水果，直到有一个为空
                    if(basketOne.containsKey(tree[j])){
                        int i1 = basketOne.get(tree[j]) - 1;
                        basketOne.put(tree[j], i1);
                        currentCount--;
                        if(i1==0){
                            basketOne.remove(tree[j]);
                            i--;
                            indexSecond = j+1;
                            break;
                        }
                    }else if(basketSecond.containsKey(tree[j])){
                        int i1 = basketSecond.get(tree[j]) - 1;
                        currentCount--;
                        basketSecond.put(tree[j], i1);
                        if(i1==0){
                            basketSecond.remove(tree[j]);
                            i--;
                            indexSecond = j+1;
                            break;
                        }
                    }
                    
                }
            }
        }
        
        return maxCount;
    }

    public static void main(String[] args) {
        int[] tmp = {3,3,3,1,2,1,1,2,3,3,4};
        PicFruit picFruit = new PicFruit();
        picFruit.totalFruit(tmp);
    }
}

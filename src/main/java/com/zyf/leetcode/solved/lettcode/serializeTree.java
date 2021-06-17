package com.zyf.leetcode.solved.lettcode;

/**
 * @Title: serializeTree.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束，但要求能够根据序列化之后的字符串重新构造出一棵与原二叉树相同的树。
 * <p>
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 例如，可以根据层序遍历并特定标志空结点的方案序列化，也可以根据满二叉树结点位置的标号规律来序列化，还可以根据先序遍历和中序遍历的结果来序列化。
 * <p>
 * 假如一棵树共有 2 个结点， 其根结点为 1 ，根结点右子结点为 2 ，没有其他结点。按照上面第一种说法可以序列化为“1,#,2,#,#”，按照上面第二种说法可以序列化为“{0:1,2:2}”，按照上面第三种说法可以序列化为“1,2;2,1”，这三种序列化的结果都包含足以构建一棵与原二叉树完全相同的二叉树的信息。
 * <p>
 * 不对序列化之后的字符串进行约束，所以欢迎各种奇思妙想。
 * 示例1
 * 输入：
 * {8,6,10,5,7,9,11}
 * 复制
 * 返回值：
 * {8,6,10,5,7,9,11}
 * @Author: Administrator
 * @Date: 2021/6/17 17:16
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class serializeTree {
    
    private String deserialize;

    /**
     * 序列化
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {

        if (root == null) {
            return "#";
        }
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }

    /**
     * 反序列化
     *
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        deserialize = str;
        int index = str.indexOf(",");
        String val = index == -1 ? str : str.substring(0,index);
        deserialize = index == -1?"":str.substring(index+1);
        if(val.equals("#")){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(val));
        treeNode.left = Deserialize(deserialize);
        treeNode.right = Deserialize(deserialize);
        
        return treeNode;
    }
}

package com.zyf.leetcode.solved.lettcode;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Title: FindNextNode.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 二叉树的下一个结点
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 * @Author: Administrator
 * @Date: 2021/6/4 18:19
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class FindNextNode implements Serializable {
    private int i = 1;
    private int j = 2;
    private int v = 3;
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //如果右节点不为null，则下一节点为右节点的最左侧节点
        TreeLinkNode right;
        if((right = pNode.right) !=null){
            while (right.left!=null){
                right = right.left;
            }
            return right;
        }else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode){
                    return parent;
                }
                    
                pNode = pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        //服务端
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket socket = serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        socket.bind(inetSocketAddress);
        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel)next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                }else if(next.isReadable()){
                    SocketChannel channel = (SocketChannel)next.channel();
                    //读取channel
                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                    StringBuilder data = new StringBuilder();
                    while (true){
                        byteBuffer.clear();
                        int read = channel.read(byteBuffer);
                        if(read == -1){
                            break;
                        }
                        byteBuffer.flip();
                        int limit = byteBuffer.limit();
                        char[] dst = new char[limit];
                        for (int i = 0; i < limit; i++) {
                            dst[i] = (char) byteBuffer.get(i);
                        }
                        data.append(dst);
                        byteBuffer.clear();
                        System.out.println(data.toString());
                       
                    }
                    channel.close();

                }
            }
        }
        
    }
    
    
    
}

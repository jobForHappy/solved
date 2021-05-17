package com.zyf.leetcode.solved.lettcode;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Title: MyselfClassLoad.java
 * @Package com.zyf.leetcode.solved.lettcode
 * @Description: 自定义类加载器
 * @Author: Administrator
 * @Date: 2021/4/23 11:12
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MyselfClassLoad extends ClassLoader{
    /**
     * 类加载路径
     */
    private String path;
    
    MyselfClassLoad(String path){
        this.path = path;
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //根据路径获取类
        byte[] classData = getdata();
        
        if(classData!=null){
            return defineClass(name, classData, 0, classData.length);
        }

        throw new ClassNotFoundException(name);
    }

    private byte[] getdata() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(path)))) {
            byte[] buffer = new byte[1024];
            int size;
            while ((size = in.read(buffer)) != -1) {
                out.write(buffer, 0, size);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static void main(String[] args) {
        MyselfClassLoad myselfClassLoad = new MyselfClassLoad("E:\\self\\adverisement_manager\\solved\\target\\classes\\com\\zyf\\leetcode\\solved\\lettcode\\MostNumber.class");
        try {
            Class<?> myclass = myselfClassLoad.loadClass("com.zyf.leetcode.solved.lettcode.MostNumber");
            System.out.println("类加载器是:" + myclass.getClassLoader());
            Method method = myclass.getDeclaredMethod("main", String[].class);
            Object object = myclass.newInstance();
            String[] arg = {"ad"};
            method.invoke(object, (Object) arg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

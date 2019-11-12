package com.leon.demo.loadorder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/9/5
 */
public class NetworkClassLoader extends ClassLoader {
    private String rootUrl;

    public NetworkClassLoader(String rootUrl) {

        this.rootUrl = rootUrl;

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class clazz = null;//this.findLoadedClass(name); // 父类已加载

        //if (clazz == null) {  //检查该类是否已被加载过

        byte[] classData = getClassData(name);  //根据类的二进制名称,获得该class文件的字节码数组

        if (classData == null) {

            throw new ClassNotFoundException();

        }
        clazz = defineClass(name, classData, 0, classData.length);  //将class的字节码数组转换成Class类的实例
        //}
        return clazz;
    }


    private byte[] getClassData(String name) {

        InputStream is = null;

        try {

            String path = classNameToPath(name);

            URL url = new URL(path);

            byte[] buff = new byte[1024 * 4];

            int len = -1;

            is = url.openStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ((len = is.read(buff)) != -1) {

                baos.write(buff, 0, len);

            }

            return baos.toByteArray();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (is != null) {

                try {

                    is.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }

        return null;

    }


    private String classNameToPath(String name) {
        return rootUrl + "/" + name.replace(".", "/") + ".class";
    }


    public static void main(String[] args) {
        try {
            String rootUrl = "https://github.com/leon-fly/demo/raw/master/corejava/src/main/java/";

            NetworkClassLoader networkClassLoader = new NetworkClassLoader(rootUrl);

            String classname = "com.leon.demo.HelloWorld";

            Class clazz = networkClassLoader.loadClass(classname);

            ClassLoader classLoader = clazz.getClassLoader();
            System.out.println("HelloWorld的类加载器:" + clazz.getClassLoader());

            getParentClassLoader(classLoader);


            System.out.println("\n从网络加载的类为：" + clazz.getName());
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, new Object[]{new String[]{}});

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static ClassLoader getParentClassLoader(ClassLoader classLoader) {
        ClassLoader parentClassLoader = classLoader.getParent();
        if (parentClassLoader != null) {
            System.out.println(classLoader + "的父类为-->" + parentClassLoader);
            return getParentClassLoader(parentClassLoader);
        }
        return null;
    }
}

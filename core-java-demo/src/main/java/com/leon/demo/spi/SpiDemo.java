package com.leon.demo.spi;

import java.util.ServiceLoader;

/**
 * @Author : leonwang
 * @Descpriction 定义好接口与实现类，在resource目录下创建META-INF/services目录，目录中添加接口全限定名为名称的文件，
 * 文件中写入每个实现类的全限定名，一个实现类一行，那么通过ServiceLoader就可以加载其实现类并实例话。
 * @Date:created 2020/3/1
 */
public class SpiDemo {
    public static void main(String[] args) {
        ServiceLoader<Speaker> speakers = ServiceLoader.load(Speaker.class);
        for (Speaker speaker : speakers) {
            speaker.sayHello();
        }
    }
}

package com.leon.demo.memory;

import java.util.List;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/26
 */
public class MemoryKiller {

    public static void boom(List list){
        for (int i = 0; ; i++) {
            list.add(new byte[1024 * 1024]);
            System.out.println("载入1M,载入次数：" + i);
        }
    }
}

package com.leon.demo.memory.leek;


import java.util.ArrayList;
import java.util.Random;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/19
 */

public class LeakHolder {
    private ArrayList<int[]> arrayList = new ArrayList();

    public ArrayList<int[]> getArrayList() {
        return arrayList;
    }


    public void allocate() {
        Random random = new Random();
        arrayList = new ArrayList();
        for (int i = 0; i < 500; i++) {

            int [] element = new int[1024 * 1024];
            for (int a = 0; a < 1024 * 1024; a++) {
                element[i] = random.nextInt();
            }

            arrayList.add(new int[1024 * 1024]);
        }
    }
}

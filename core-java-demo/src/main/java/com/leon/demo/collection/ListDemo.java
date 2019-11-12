package com.leon.demo.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/10/2
 */
public class ListDemo {
    public static void main(String[] args) {
        new ListDemo().testArrayList();
    }

    private void testArrayList(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        for (Integer integer : al) {
            System.out.println(integer);
        }
    }

    private void testLinkedList(){
        LinkedList<Integer> al = new LinkedList<>();
        al.add(1);
        al.add(2);
        al.add(3);
    }
}

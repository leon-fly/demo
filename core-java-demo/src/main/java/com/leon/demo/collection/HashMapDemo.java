package com.leon.demo.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        System.out.println(hashMap.size());
//        testHashMapKeyOrder();
//        testLinkedHashMapKeyOrder();
    }

    private static void testHashMapKeyOrder() {
        System.out.println("验证hashmap key无序性");
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("5", "e");
        map.put("2", "b");

        map.keySet().forEach(key -> {
            System.out.println("key:" + key);
        });

        map.entrySet().forEach(entry -> {
            System.out.println("entryKey:" + entry.getKey());
        });
    }

    /**
     * linkedHashMap key有序
     */
    private static void testLinkedHashMapKeyOrder() {
        System.out.println("验证linkedHashMapKey有序性");
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("5", "e");
        map.put("2", "b");

        map.keySet().forEach(key -> {
            System.out.println("key:" + key);
        });

        map.entrySet().forEach(entry -> {
            System.out.println("entryKey:" + entry.getKey());
        });

        map.put("5", "1a");
        map.put("3", "c");
        map.keySet().forEach(key -> {
            System.out.println("key:" + key);
        });

        map.entrySet().forEach(entry -> {
            System.out.println("entryKey:" + entry.getKey());
        });

    }

}

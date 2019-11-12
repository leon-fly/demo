package com.leon.demo.switch_;

public class SwitchDemo {
    public static void main(String[] args) {
        /**
         * 从1.7开始可以switch可以使用string
         */
        String str  = "key1";
        switch(str){
            case "key1" :
                System.out.println("hello: key1");
                break;
            case "key2" :
                System.out.println("hello: key2");
        }
    }


}

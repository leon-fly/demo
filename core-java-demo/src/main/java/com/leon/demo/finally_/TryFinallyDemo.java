package com.leon.demo.finally_;

public class TryFinallyDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main:" + getNum(5));
        System.out.println("===================");

        System.out.println("main：" + getNum2(5));
        System.out.println("===================");

        StringBuffer sb = new StringBuffer("");
        System.out.println(testStringBuffer(sb));

        System.out.println("==================");
        System.out.println(testString("abc"));
    }

    /**
     * 返回的值为执行到return时的值
     *
     * @param a
     * @return
     */
    public static int getNum(int a) {
        try {
            return a++;
        } finally {
            System.out.println("finally-1:" + a);
            a++;
            System.out.println("finally-2:" + a);
        }
    }

    @SuppressWarnings("finally")
    public static int getNum2(int a) {
        try {
            ++a;
        } finally {
            return a++;
        }
    }

    public static StringBuffer testStringBuffer(StringBuffer sb) throws InterruptedException {
        try {
            sb.append("try");
            return sb;
        } finally {
            sb.append(" finally");
        }
    }

    public static String testString(String sb) throws InterruptedException {
        try {
            return sb;
        } finally {
            sb = sb + " finally";
        }
    }

}

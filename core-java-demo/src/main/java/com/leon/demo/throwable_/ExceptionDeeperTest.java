package com.leon.demo.throwable_;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/12/30
 */
public class ExceptionDeeperTest {

    public static void main(String[] args) {
        ExceptionDeeperTest test = new ExceptionDeeperTest();
//       test.testNoExceptionThrows();  //无异常抛出时，二者无性能差异，与字节码推测结论一致。

        test.testThrowDiffException();

    }

    /**
     * 测试无异常抛出时catch对性能影响
     *
     * @param
     * @return
     */
    public void testNoExceptionThrows() {
        int runTimes = 20000000;

        long current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            doStuffNoCatch(i + "");
        }

        System.out.println("不捕获异常耗时：" + (System.currentTimeMillis() - current));

        current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            doStuff(i + "");
        }
        System.out.println("捕获异常耗时：" + (System.currentTimeMillis() - current));

        System.out.println("---------------------- 调整测试顺序 -----------------------");

        current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            doStuffNoCatch(i + "");
        }

        System.out.println("不捕获异常耗时：" + (System.currentTimeMillis() - current));

        current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            doStuff(i + "");
        }
        System.out.println("捕获异常耗时：" + (System.currentTimeMillis() - current));
    }

    public void testThrowDiffException() {
        int runTimes = 5000;

        long current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            try {
                doStuff(i + "x");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long time1 = System.currentTimeMillis() - current;

        current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            try {
                doStuffThrowNew(i + "x");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long time2 = System.currentTimeMillis() - current;


        current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            try {
                doStuffThrowNew(i + "x");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long time3 = System.currentTimeMillis() - current;

        current = System.currentTimeMillis();
        for (int i = 0; i < runTimes; i++) {
            try {
                doStuff(i + "x");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long time4 = System.currentTimeMillis() - current;
        System.out.println("捕获原异常耗时：" + time1);
        System.out.println("捕获新异常耗时：" + time2);
        System.out.println("---------------------- 调整测试顺序 -----------------------");
        System.out.println("捕获新异常耗时：" + time3);
        System.out.println("捕获原异常耗时：" + time4);



    }


    public int doStuffNoCatch(String s) {
        return Integer.parseInt(s);
    }

    public int doStuff(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public int doStuffThrowNew(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException("NumberFormatException");
        }
    }

}

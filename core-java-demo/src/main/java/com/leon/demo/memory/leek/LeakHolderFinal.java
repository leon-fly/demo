package com.leon.demo.memory.leek;

/**
 * @Author : leonwang
 * @Descpriction 内存泄漏分析练习工具，运行后内存溢出产生heapdump文件
 * -XX:+UseConcMarkSweepGC  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+HeapDumpOnOutOfMemoryError
 * @Date:created 2020/1/19
 */
public class LeakHolderFinal {
    private LeakHolder leakHolder;

    public static void main(String[] args) {
        LeakHolder leakHolder = new LeakHolder();
        leakHolder.allocate();

        LeakHolderFinal leakHolderFinal = new LeakHolderFinal();
        leakHolderFinal.setLeakHolder(leakHolder);

        leakHolderFinal.getLeakHolder().getArrayList()
                .forEach(
                        intArray -> {
                            for (int i : intArray) {
                                System.out.println(Math.log10(i));
                            }
                        }
                );
    }

    public LeakHolder getLeakHolder() {
        return leakHolder;
    }

    public void setLeakHolder(LeakHolder leakHolder) {
        this.leakHolder = leakHolder;
    }
}

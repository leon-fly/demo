package com.leon.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author : leonwang
 * @Descpriction 堆排序 时间复杂度o(nlogn) 原地排序。排序过程分为建堆和排序
 * @Date:created 2019/11/22
 */
public class HeapSortDemo {

    public static void main(String[] args) {
        HeapSortDemo heapSortDemo = new HeapSortDemo();
        int[] data = new int[]{772, 951, 192, 187, 232, 31, 934, 926, 513, 74, 66, 497, 461, 668, 394, 891, 608, 151, 822, 308, 491, 164, 241, 225, 150, 223, 659, 863, 726, 637, 315, 569, 738, 21, 98, 333, 935, 208, 755, 892, 790, 389, 48, 70, 524, 205, 94, 514, 4, 366, 578, 477, 716, 170, 886, 746, 291, 258, 590, 210, 979, 447, 562, 713, 221, 564, 457, 262, 213, 124, 177, 238, 868, 555, 269, 875, 955, 972, 542, 901, 983, 774, 814, 342, 924, 570, 683, 72, 193, 274, 20, 379, 895, 385, 549, 284, 856, 982, 728, 874};  //非0数据,不重复
        heapSortDemo.sortDesc(data);
        heapSortDemo.sortAsc(data);
    }

    public void sortDesc(int[] initData) {
        Heap heap = new Heap(initData);
        System.out.println("建大顶堆：" + Arrays.toString(heap.getHeapData()));

        System.out.println("降序排序过程：");
        ArrayList list = new ArrayList();
        for (int i = 1; i < heap.getHeapData().length; i++) {
            int top = heap.deleteHeapTopElement();
            System.out.println("移除堆顶元素重新堆化" + i + "：" + Arrays.toString(heap.getHeapData()));
            list.add(top);
        }
        System.out.println("降序排序：" + list);
    }

    public void sortAsc(int[] initData) {
        Heap heap = new Heap(initData, Heap.HEAP_TYPE_MIN);
        System.out.println("建小顶堆：" + Arrays.toString(heap.getHeapData()));

        ArrayList list = new ArrayList();
        for (int i = 1; i < heap.getHeapData().length; i++) {
            int top = heap.deleteHeapTopElement();
            list.add(top);
        }
        System.out.println("升序排序：" + list);
    }

}

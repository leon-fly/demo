package com.leon.demo.algorithm;

/**
 * @Author : leonwang
 * @Descpriction
 * 堆是一个完全二叉树；
 * 堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 *
 * 数组中下标为 i 的节点的左子节点，就是下标为 i∗2 的节点，右子节点就是下标为 i∗2+1 的节点，父节点就是下标为 i/2​ 的节点
 * @Date:created 2019/11/22
 */
public class Heap {
    private int[] heapData;
    private int capacity;
    private int size;
    private int heapType = HEAP_TYPE_MAX;

    public static final int HEAP_TYPE_MAX = 1;  //大顶堆
    public static final int HEAP_TYPE_MIN = 0;  //小顶堆


    public Heap(int capacity) {
        this.capacity = capacity;
        heapData = new int[capacity + 1];
    }

    public Heap(int capacity, int heapType) {
        this.capacity = capacity;
        this.heapType = heapType;
        heapData = new int[capacity + 1];
    }

    public Heap(int[] initData) {
        createHeap(initData);
    }

    public Heap(int[] initData, int heapType) {
        this.heapType = heapType;
        createHeap(initData);
    }


    public int[] getHeapData() {
        return heapData;
    }

    /**
     * 建堆（使用大顶堆）
     *
     * @param initData
     * @return
     */
    public int[] createHeap(int[] initData) {
        capacity = initData.length;
        heapData = new int[initData.length + 1];
        for (int i = 0; i < initData.length; i++) {
            insertElementToHeap(initData[i]);
        }
        return heapData;
    }


    /**
     * @param element 要插入元素
     */
    public void insertElementToHeap(int element) {
        if (size >= capacity) {
            throw new RuntimeException("can't insert element any more");
        }
        heapData[++size] = element;
        if (size == 1) {
            return;
        }
        heapifyUpward(heapData, size);
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int deleteHeapTopElement() {
        int top = heapData[1];
        heapData[1] = heapData[size];
        heapData[size] = 0; //置空 可以不处理
        heapifyDownward(heapData, 1, --size);
        return top;
    }


    /**
     * 自上往下堆化（适合删除元素后重新堆化，把最后一个元素放到删除元素的位置，自上往下堆化与父子节点比较交换使其满足堆特点）
     *
     * @param heapData
     * @param elementIndex
     * @param lastNodeIndex
     */
    private void heapifyDownward(int[] heapData, int elementIndex, int lastNodeIndex) {
        int leftNodeElementIndex = elementIndex * 2;
        int rightNodeElementIndex = elementIndex * 2 + 1;

        //叶子节点
        if (leftNodeElementIndex > lastNodeIndex) {
            return;
        }

        //只有左子节点
        if (rightNodeElementIndex > lastNodeIndex) {
            if ((heapData[elementIndex] < heapData[leftNodeElementIndex] && heapType == HEAP_TYPE_MAX)
                    || (heapData[elementIndex] > heapData[leftNodeElementIndex] && heapType == HEAP_TYPE_MIN)) {
                swap(heapData, elementIndex, leftNodeElementIndex);
                heapifyDownward(heapData, leftNodeElementIndex, lastNodeIndex);
            }
            return;
        }

        if (heapType == HEAP_TYPE_MAX && (heapData[elementIndex] < heapData[leftNodeElementIndex] || heapData[elementIndex] < heapData[rightNodeElementIndex])) {
            if (heapData[leftNodeElementIndex] < heapData[rightNodeElementIndex]) {
                swap(heapData, elementIndex, rightNodeElementIndex);
                heapifyDownward(heapData, rightNodeElementIndex, lastNodeIndex);
                return;
            }

            swap(heapData, elementIndex, leftNodeElementIndex);
            heapifyDownward(heapData, leftNodeElementIndex, lastNodeIndex);
            return;
        }

        if (heapType == HEAP_TYPE_MIN && (heapData[elementIndex] > heapData[leftNodeElementIndex] || heapData[elementIndex] > heapData[rightNodeElementIndex])) {
            if (heapData[leftNodeElementIndex] > heapData[rightNodeElementIndex]) {
                swap(heapData, elementIndex, rightNodeElementIndex);
                heapifyDownward(heapData, rightNodeElementIndex, lastNodeIndex);
                return;
            }

            swap(heapData, elementIndex, leftNodeElementIndex);
            heapifyDownward(heapData, leftNodeElementIndex, lastNodeIndex);
            return;
        }

    }


    /**
     * 自下往上堆化（适合在插入元素元素后的堆化，把元素放到最后一个节点）
     *
     * @param heapData
     * @param elementIndex
     */
    private void heapifyUpward(int[] heapData, int elementIndex) {
        if (elementIndex == 1) {
            return;
        }

        int fatherElementIndex = 0;
        if (elementIndex % 2 == 0) { //左子节点
            fatherElementIndex = elementIndex / 2;
        } else { //右子节点
            fatherElementIndex = (elementIndex - 1) / 2;
        }

        if ((heapData[fatherElementIndex] < heapData[elementIndex] && heapType == HEAP_TYPE_MAX)
                || (heapData[fatherElementIndex] > heapData[elementIndex] && heapType == HEAP_TYPE_MIN)) {
            swap(heapData, fatherElementIndex, elementIndex);
            heapifyUpward(heapData, fatherElementIndex);
        }
    }


    /**
     * 数组数据交换
     *
     * @param data
     * @param positionA
     * @param positionB
     */
    private void swap(int[] data, int positionA, int positionB) {
        int temp = data[positionA];
        data[positionA] = data[positionB];
        data[positionB] = temp;
    }

}

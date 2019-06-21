package heap.easy;

import java.util.PriorityQueue;

/*
* 数据流中第k大的元素
* */
public class KthLargest {

    //需要使用小根堆
    PriorityQueue<Integer> pq;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>(k);    //维护大小为k的堆，堆顶元素最小即第k大的元素
        for (int num:nums){
            add(num);
        }

    }

    public int add(int val) {
        if (pq.size() < size){
            pq.add(val);
        }else{
            if (pq.peek() < val){
                pq.poll();
                pq.add(val);
            }

        }
        return pq.peek();
    }
}

package medium.heap;

import java.util.PriorityQueue;

/*
* 215. 数组中的第K个最大元素
* */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {

        if (nums.length < k)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num:nums){
            if (pq.size() < k)
                pq.add(num);
            else {
                if (num > pq.peek()){
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.peek();
    }
}

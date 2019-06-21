package heap.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 最后一块石头的重量
* */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {

        int result = 0;
        //大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(stones.length,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int s:stones) {
            pq.offer(s);
        }

        while (pq.size() > 1){
            int max = pq.poll();
            int second = pq.poll();
            int diff = max - second;
            if(diff != 0)
                pq.offer(diff);
        }
            if (pq.size() > 0)
                result = pq.peek();
        return  result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,4,1,8,1};
        new LastStoneWeight().lastStoneWeight(nums);
    }
}

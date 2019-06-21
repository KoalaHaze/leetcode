package medium.heap;

import java.util.*;

/*
* 347. 前K个高频元素
* */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {

            HashMap<Integer,Integer> hm = new HashMap<>();
            for (int num:nums){
                if (hm.containsKey(num))
                    hm.put(num,hm.get(num)+1);
                else
                    hm.put(num,1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return hm.get(o1) - hm.get(o2);
                }
            });
            for (Map.Entry<Integer,Integer> entry:hm.entrySet()){
                if (pq.size() < k)
                    pq.add(entry.getKey());
                else {
                    if (entry.getValue() > hm.get(pq.peek())){
                        pq.poll();
                        pq.add(entry.getKey());
                    }
                }
            }
            List<Integer> list = new ArrayList<>();
            while (pq.size()>0){
                list.add(pq.poll());
            }
            return list;
    }
}

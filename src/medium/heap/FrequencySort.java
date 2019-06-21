package medium.heap;

import java.util.*;

/*
* 451. 根据字符出现频率排序
* */
public class FrequencySort {
    public String frequencySort(String s) {

        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (hm.containsKey(c))
                hm.put(c,hm.get(c)+1);
            else
                hm.put(c,1);
        }
        StringBuilder sb = new StringBuilder();
        /*PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return hm.get(o2) - hm.get(o1);
            }
        });
        for (char key:hm.keySet()){
            pq.offer(key);
        }
        while (pq.size() > 0){
            while (hm.get(pq.peek()) > 1){
                sb.append(pq.peek());
                hm.put(pq.peek(),hm.get(pq.peek())-1);
            }
            sb.append(pq.poll());
        }*/

        List[] lists = new ArrayList[s.length()];

        for (Map.Entry<Character,Integer> entry:hm.entrySet()){
            if (lists[entry.getValue()] == null)
                lists[entry.getValue()] = new ArrayList<Character>();
            lists[entry.getValue()].add(entry.getKey());
        }

        for (int i=lists.length-1;i>0;i--){
            if (lists[i] != null){
                for (int j=0;j<lists[i].size();j++){
                    for (int k=i;k>0;k--){
                        sb.append(lists[i].get(j));
                    }
                }

            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        new FrequencySort().frequencySort(s);
    }
}

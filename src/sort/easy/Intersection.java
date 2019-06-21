package sort.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* 349. 两个数组的交集
* */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {

        /*Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1:nums1) {
            set1.add(num1);
        }
        for (int num2:nums2) {
            if (set1.contains(num2))
                set2.add(num2);
        }

        int[] result = new int[set2.size()];
        Iterator<Integer> it = set2.iterator();
        int num = 0;
        while (it.hasNext()){
            result[num] = it.next();
            num++;
        }
        return result;*/

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums1){
            hm.put(num,0);
        }
        Set<Integer> set = new HashSet<>();
        for(int num:nums2){
            if(hm.containsKey(num))
                set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            result[index++] = it.next();
        }
        return result;

    }

}

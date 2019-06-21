package sort.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* 350. 两个数组的交集 II
* */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {

        /*List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num1:nums1){
            list1.add(num1);
        }
        for (int num2:nums2){
            if (list1.contains(num2)){
                list2.add(num2);
                list1.remove(Integer.valueOf(num2));
            }
        }
        int[] result = new int[list2.size()];
        for (int i=0;i<list2.size();i++){
            result[i] = list2.get(i);
        }
        return result;*/

        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int num:nums1){
            if (hm.containsKey(num))
                hm.put(num,hm.get(num)+1);
            else
                hm.put(num,1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num:nums2){
            if (hm.containsKey(num) && hm.get(num)>0){
                list.add(num);
                hm.put(num,hm.get(num)-1);
            }
        }
        int[] result = new int[list.size()];
        for (int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,9};
        int[] nums2 = {9,4,9,8,32};
        new Intersect().intersect(nums1,nums2);
    }
}

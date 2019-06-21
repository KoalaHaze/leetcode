package array.easy;

import java.util.HashMap;

/*
* 219. 存在重复元素 II
 * */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (hm.containsKey(nums[i]) && Math.abs(hm.get(nums[i])-i) <= k){
                return true;
            }
            hm.put(nums[i],i);
        }
        return false;
    }
}

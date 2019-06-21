package BitOperation.easy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 169. 求众数
* */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        /*HashMap<Integer,Integer> hm = new HashMap<>();
        for (int num:nums){
            if (hm.containsKey(num))
                hm.put(num,hm.get(num)+1);
            else
                hm.put(num,1);
        }

        int max = 0;
        int num = 0;
        for (Map.Entry entry:hm.entrySet()){
            if ((int)entry.getValue() > num) {
                num = (int)entry.getValue();
                max = (int) entry.getKey();
            }
        }
        return max;*/
        Arrays.sort(nums);
        return nums[Math.round(nums.length/2)];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,4};
        new MajorityElement().majorityElement(nums);
    }
}

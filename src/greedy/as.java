package greedy;

import java.util.HashMap;
import java.util.Map;

public class as {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int n=0;n<nums.length;n++) {
            hm.put(nums[n],n);
        }
        int[] result = new int[2];
        for (int k=0;k<=hm.size();k++){
            int second = target - nums[k];

            if (hm.containsKey(second) && k !=hm.get(second)){
                result[0] = k;
                result[1] = hm.get(second);
                break;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arg = {3,2,4};
        new as().twoSum(arg,6);
    }
}

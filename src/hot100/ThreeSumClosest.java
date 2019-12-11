package hot100;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for (int i=0;i<len;i++){
            int l = i+1;
            int r = len-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum > target)
                    r--;
                else if (sum < target)
                    l++;
                else
                    return target;
                int diff = Math.abs(sum - target);
                if(diff < Math.abs(res-target))
                    res = sum;


            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        new ThreeSumClosest().threeSumClosest(nums,-1);
    }
}

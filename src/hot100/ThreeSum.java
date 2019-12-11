package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 三数之和，不包含重复list
* */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3)
            return res;
        Arrays.sort(nums);
        for (int i=0;i<len;i++){
//            当最小值大于0则不可能成立
            if (nums[i] > 0)
                break;
//            去掉重复的
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i+1;
            int r = len - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0)
                    r--;
                else if (sum < 0)
                    l++;
                else if (sum == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
//                    左右各移一位，去重
                    while (l<r && nums[l] == nums[l+1])
                        l++;
                    while (r>l && nums[r] == nums[r-1])
                        r--;

                    l++;
                    r--;
                }
            }
        }

        return res;
    }
}
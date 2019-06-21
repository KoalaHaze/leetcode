package medium.Top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 15. 三数之和
* */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (i==0 || i>0&&nums[i]!=nums[i-1]){//跳过可能重复的
            int l = i+1 , r = nums.length-1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    //去掉重复的答案
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    r--;
                }
            }

            }

        }

        return result;
    }
}

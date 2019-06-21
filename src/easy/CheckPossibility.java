package easy;

import java.util.PriorityQueue;

/*
* 665. 非递减数列
* */
public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {

        if (nums.length < 2)
            return false;
        int change = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i] < nums[i-1]) {
                change++;
                if (i > 1 && nums[i] < nums[i-2] && i < nums.length-1 && nums[i+1] < nums[i-1])
                    return false;

            }
        }
        return change <= 1;
    }
}

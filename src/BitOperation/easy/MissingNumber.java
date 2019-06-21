package BitOperation.easy;

import java.util.Arrays;

/*
* 268. 缺失数字
* */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        /*if (nums.length == 0)
            return -1;
        int len = nums.length;
        Arrays.sort(nums);

        for (int i=0;i<len;i++){
            if (i != nums[i])
                return  i;
        }
        return len;*/

        int len = nums.length;
        for (int i=0;i<nums.length;i++){
            len = len^nums[i];
            len = len^i;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        new MissingNumber().missingNumber(nums);
    }
}

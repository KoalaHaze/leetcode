package dynamicPlanning.easy;

/*
* 53. 最大子序和
* */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int result = nums[0];
        int sum = 0;
        for (int num:nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;

            result = Math.max(result,sum);
        }
        return result;
    }
}

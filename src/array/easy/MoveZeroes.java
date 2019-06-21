package array.easy;

import java.util.Arrays;

/*
* 283. 移动零
* */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for (int j=0;j<nums.length;j++){
            if (nums[j] != 0)
                nums[i++] = nums[j];
        }

        for (int k=i;k<nums.length;k++)
            nums[k] = 0;

    }
}

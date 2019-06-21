package easy;

import java.util.Arrays;

/*
* 704. 二分查找
* */
public class Search {
    public int search(int[] nums, int target) {


        if (nums.length < 1)
            return -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        new Search().search(nums,2);
    }
}

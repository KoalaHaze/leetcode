package array.easy;

/*
* 26. 删除排序数组中的重复项
* */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j=0;j<nums.length;j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}

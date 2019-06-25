package medium.Top;

/*
* 34. 在排序数组中查找元素的第一个和最后一个位置
* */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length < 1)
            return result;

        int left = find(nums,target,false);
        if (left >= nums.length || nums[left] != target )
            return result;

        int right = find(nums,target,true)-1;
        if (right < left || nums[right] != target)
            return result;
        result[0] = left;
        result[1] = right;
        return result;
    }

    public int find(int[] nums,int target,boolean isRight){
        int start = 0 , end = nums.length;
        while (start < end){
            int mid = (start+end)/2;
            if (nums[mid] < target || (isRight && nums[mid] == target)){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[] nums = {2,2};
        new  SearchRange().searchRange(nums,3);
    }
}

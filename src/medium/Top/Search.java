package medium.Top;

/*
* 33. 搜索旋转排序数组
* */
public class Search {
    public int search(int[] nums, int target) {

        int start = 0 , end = nums.length-1;
        while (start < end){
            int mid = (start+end)/2;
            if (nums[mid] > nums[end]){
                start = mid+1;
            }else
                end = mid;
        }

        int left = 0 , right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            int realMid = (mid+start)%nums.length;
            if (nums[realMid] == target)
                return realMid;
            else if (nums[realMid] > target)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;

    }



    public static void main(String[] args) {
        int[] nums = {3,1};
        new Search().search(nums,3);
    }
}

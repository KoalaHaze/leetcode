package medium.Top;

/*
* 11. 盛最多水的容器
 * */
public class MaxArea {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right){
            int width = right - left;
            int heigh = Math.min(height[left],height[right]);
            if (width*heigh > max)
                max = width*heigh;
            if (heigh == height[left])
                left++;
            else
                right--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        new MaxArea().maxArea(nums);
    }
}

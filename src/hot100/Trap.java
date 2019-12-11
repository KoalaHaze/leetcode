package hot100;

/*
* 42. 接雨水
* */
public class Trap {
    public int trap(int[] height) {

        int area = 0;
        if(height.length < 2)
            return area;
        int l = 0 , r = height.length-1;
        int l_max = height[l] , r_max = height[r];
        while (l < r){
            if (height[l] < height[r]){
                if (l_max <= height[l])
                    l_max = height[l];
                else
                    area += l_max-height[l];
                l++;
            }
            else {
                if (r_max <= height[r])
                    r_max = height[r];
                else
                    area += r_max-height[r];
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        new Trap().trap(nums);
    }
}

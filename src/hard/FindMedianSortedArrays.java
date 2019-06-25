package hard;

/*
* 4. 寻找两个有序数组的中位数
* */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        if (m > n){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int temp = m;
            m = n;
            n = temp;
        }

        int iMin = 0 , iMax = m , half = (m+n+1)/2;
        while (iMax >= iMin){
            int i = (iMax+iMin)/2;
            int j = half - i;

            if (i < iMax && nums1[i] < nums2[j-1])
                iMin = i+1;
            else if (i > iMin && nums1[i-1] > nums2[j])
                iMax = i-1;
            else {
                int maxLeft = 0;
                if (i == 0)
                    maxLeft = nums2[j-1];
                else if (j == 0)
                    maxLeft = nums1[i-1];
                else
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);

                if ((n+m)%2 == 1)
                    return maxLeft;

                int minRight = 0;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i],nums2[j]);

                return (maxLeft+minRight)/2.0;

            }
        }

        return 0.0;
    }
}

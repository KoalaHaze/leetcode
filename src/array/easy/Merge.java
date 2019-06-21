package array.easy;

/*
* 88. 合并两个有序数组
* */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1;
            int j = n-1;
            for (int k=m+n-1;k>=0;k--){
                if (i < 0) {
                    nums1[k] = nums2[j];
                    j--;
                    continue;
                }
                if (j < 0) {
                    nums1[k] = nums1[i];
                    i--;
                    continue;
                }

                if(nums1[i] < nums2[j]) {
                    nums1[k] = nums2[j];
                    j--;
                }else {
                    nums1[k] = nums1[i];
                    i--;
                }

            }

    }

    public static void main(String[] args) {
        int[] n1 = {0};
        int[] n2 = {1};
        new Merge().merge(n1,0,n2,1);
    }
}

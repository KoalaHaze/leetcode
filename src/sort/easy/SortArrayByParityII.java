package sort.easy;

import java.util.ArrayList;
import java.util.List;

/*
* 922. 按奇偶排序数组 II
* */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {

        /*int j = 0;
        int o = 0;
        int len = A.length;
        int index = 0;
        int[] result = new int[A.length];
        for (int i=0;i<len;i++){
             if (i%2 == 0){
                 for (int k=j;k<len;k++){
                     if (A[k]%2 == 0){
                         j=k+1;
                         result[index++] = A[k];
                         break;
                     }
                 }
             }else{
                 for (int k=o;k<len;k++){
                     if (A[k]%2 == 1){
                         o=k+1;
                         result[index++] = A[k];
                         break;
                     }
                 }
             }
        }

        return result;*/


        int j = 1;
        int o = 0;
        int len = A.length;
        int[] result = new int[len];
        for (int i=0;i<len;i++){
            if (A[i]%2 == 0 && o<len) {
                result[o] = A[i];
                o += 2;
            }
            else if (A[i]%2 == 1 && j<len){
                result[j] = A[i];
                j += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,2,7};
        new SortArrayByParityII().sortArrayByParityII(nums);
    }
}

package sort.easy;

import heap.easy.LastStoneWeight;

import java.util.Arrays;

/*
* 976. 三角形的最大周长
* */
public class LargestPerimeter {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i=A.length-1;i>1;i--){
            if (A[i]<(A[i-1]+A[i-2]))
                return A[i]+A[i-1]+A[i-2];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] obj = {2,1,1};
        new LargestPerimeter().largestPerimeter(obj);
    }
}

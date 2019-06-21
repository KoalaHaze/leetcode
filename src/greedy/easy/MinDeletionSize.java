package greedy.easy;


/*
* 944. 删列造序
* */
public class MinDeletionSize {
    public int minDeletionSize(String[] A) {
        if (A.length <= 0)
            return 0;
        int asize = A.length;
        int ssize = A[0].length();
        if (ssize <= 1)
            return 0;
        int  result = 0;

        for (int a=0;a<asize;a++){
            int nums = 0;
            for (int s = 1;s<ssize;s++){
                if (A[a].charAt(s) < A[a].charAt(s-1)){
                    nums ++;
                }
                if (nums > result)
                    result = nums;
            }
        }
        return asize-result;
    }

    public static void main(String[] args) {
        String[] a = {"zyx","wvu","tsr"};
        new MinDeletionSize().minDeletionSize(a);
    }
}

package dynamicPlanning.easy;


/*
* 70. 爬楼梯
* */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 1)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        int[] cs = new int[n];
        cs[0] = 1;
        cs[1] = 2;
        for (int i=2;i<n;i++){
            cs[i] = cs[i-1]+cs[i-2];
        }
        return cs[n-1];
    }
}

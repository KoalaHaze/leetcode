package medium.heap;

/*
* 264. 丑数 II
* */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        if(n < 1)
            return -1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 1 , i3 = 1 , i5 = 1;

        for (int i = 1;i<n;i++){
           int u2 = ugly[i2-1]*2;
           int u3 = ugly[i3-1]*3;
           int u5 = ugly[i5-1]*5;

           ugly[i] = Math.min(Math.min(u2,u3),u5);
           if (ugly[i] == u2)
               i2++;
            if (ugly[i] == u3)
                i3++;
            if (ugly[i] == u5)
                i5++;
        }

        return ugly[n-1];
    }

    public static void main(String[] args) {
        new NthUglyNumber().nthUglyNumber(10);
    }
}

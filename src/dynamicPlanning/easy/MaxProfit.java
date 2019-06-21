package dynamicPlanning.easy;


import java.util.Arrays;

/*
* 121. 买卖股票的最佳时机
* */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int p:prices){
            if (p<min)
                min = p;
            if (p - min > max)
                max = p - min;
        }
        return max;
    }
}

package greedy.easy;

/*
* 122. 买卖股票的最佳时机 II
* */
public class MaxProfit {
    public int maxProfit(int[] prices) {

        int max = 0;
        for (int i=0;i<prices.length-1;i++){
            if (prices[i]<prices[i+1])
                max += prices[i+1]-prices[i];
        }
        return max;
    }
}

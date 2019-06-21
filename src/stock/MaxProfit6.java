package stock;

/*
* 714. 买卖股票的最佳时机含手续费
* */
public class MaxProfit6 {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length < 2)
            return 0;
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        new MaxProfit6().maxProfit(prices,2);
    }
}

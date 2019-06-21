package stock;

/*
* 188. 买卖股票的最佳时机 IV
* */
public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2)
            return 0;
        if (k*2 > prices.length){
            int result = 0;
            for (int i=1;i<prices.length;i++){
                if (prices[i] > prices[i-1])
                    result += prices[i]-prices[i-1];
            }
            return result;
        }

        int[][][] dp = new int[prices.length][k+1][2];

        for (int i=0;i<prices.length;i++){
            for (int j=k;j>0;j--){
                if (i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                System.out.println("dp["+i+"]["+j+"][0]::" + dp[i][j][0]+"---prices:"+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                System.out.println("dp["+i+"]["+j+"][1]::" + dp[i][j][1]+"---prices:"+prices[i]);

            }
        }
        return dp[prices.length-1][k][0];
    }

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        new MaxProfit4().maxProfit(2,prices);
    }
}

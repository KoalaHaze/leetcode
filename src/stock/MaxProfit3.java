package stock;

/*
* 123. 买卖股票的最佳时机 III
* */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        if (prices.length < 2)
            return 0;
        int firstBuy = -prices[0] , firstSell = 0;   //第一次买卖的最大收益
        int secondBuy = -prices[0] , secondSell = 0; //第二次买卖的最大收益
        for (int price:prices){
            firstBuy = Math.max(firstBuy,-price);
            firstSell = Math.max(firstSell,firstBuy+price);
            secondBuy = Math.max(secondBuy,firstSell-price);
            secondSell = Math.max(secondSell,secondBuy+price);
        }
        return secondSell;
    }
}

public class maxProfit {

    public static int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        int buy = 0;
        int sell = 0;
        int profit = 0;
        int len = prices.length;
        int sum = 0;
        for(int i=len;i>1;i--){
            sum += prices[i];
        }
        float p = sum/len;
        for(int i=len;i>=1;i--){
            if((float)prices[i] > p){
                sell += prices[i];
                i--;

                for(int j=0;j<=i;j++){
                    if((float)prices[i] <= p){
                        buy += prices[j];
                        break;
                    }

                }

            }
        }
        profit = sell - buy;
        return profit;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,5};
        maxProfit(arr);
    }
}

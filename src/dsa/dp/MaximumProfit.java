package dsa.dp;

public class MaximumProfit {

    //brute force  ->   O(n * n)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            int price = prices[i];

            for(int j=i+1; j<prices.length; j++){

                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }

        return maxProfit;
    }


    // DP  -> remembering past (mini price)  0(N)
    // as we move also track mini price
    public static int maxProfitDP(int[] prices) {
        int maxProfit = 0;
        int mini = prices[0];  //buy

        for(int i=0; i<prices.length; i++){
            int sell = prices[i];
            maxProfit = Math.max(maxProfit, prices[i]-mini);

            //remembering mini
            if(prices[i]< mini){
                mini  = prices[i];
            }

        }

        return maxProfit;
    }



    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);

        int maxProfitDP = maxProfitDP(prices);
        System.out.println(maxProfitDP);

    }
}

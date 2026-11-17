package dsa.array;

public class ltm {

    public static int maxProfit(int[] price){
        int profit = 0;


        for(int i=1; i<price.length; i++){
            if(price[i]>price[i-1]){
                profit += price[i] - price[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int totalProfit = maxProfit(arr);

        System.out.println(totalProfit);
    }
}

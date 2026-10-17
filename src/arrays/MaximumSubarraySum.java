package arrays;

public class MaximumSubarraySum {

    public static void maxSubArraySum(int[] arr){
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println("Maximum subarray sum: " + maxSum);
    }


    //Kadane's Algorithm'
    public static int maxSubArraySum2(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);

            //if sum becomes negative, reset it to 0 (because a negative sum will only decrease the maximum sum)
            if(sum<0) sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, -2, 7, -4};

        maxSubArraySum(arr);

        System.out.println("Maximum subarray sum using Kadane's algorithm: " + maxSubArraySum2(arr));

    }
}

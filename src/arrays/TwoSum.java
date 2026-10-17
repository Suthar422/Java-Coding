package arrays;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,11,5,10,9,1,11};
        int target = 19;
        Arrays.sort(arr);
        int l=0,r=arr.length-1;
        while(l < r){
            int sum = arr[l]+arr[r];
            if(sum==target){
                System.out.println("Exist" +arr[l]+" "+arr[r]);
                break;
            }
            else if(sum<target){
                l++;
            }
            else{
                r--;
            }

        }
    }

}

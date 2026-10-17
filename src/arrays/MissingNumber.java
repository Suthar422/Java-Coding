package arrays;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9, 10, 12};

        Arrays.sort(arr);
        int missing = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                missing = i+1;
                break;
            }
        }
        System.out.println(missing);
    }
}

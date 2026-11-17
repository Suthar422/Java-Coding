package dsa.array.logic;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {
      //  int[] arr = {1, 0, 0, 0, 1, 3, -2};

        int[] arr = {1, 2, 1, 3, -2, 0, 0};

        //find index of 1st 0th element

        int left = 0;
        while(left<arr.length){
            if(arr[left]==0){
                break;
            }
            left++;
        }
        System.out.println(left);
        //from left idx find non 0 element and swap with them
        for(int j=left+1; j<arr.length;j++){
            if(arr[j] != 0){
                //swap and left move to next zero
                int temp = arr[left];
                arr[left] = arr[j];
                arr[j] = temp;

                left++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

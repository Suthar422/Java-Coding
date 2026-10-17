package arrays;

import java.util.Arrays;

public class ShiftZeorsAtEnd {
    public static void main(String[] args) {
      int[] arr = {1,0,2,0,0,3,4,5};

     //move zeroes at end
        int first =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                first = i;
                System.out.println(first);
                break;
            }
        }

        for(int i=first+1;i<arr.length;i++){
            if(arr[i]!=0){
                //swap
                int temp = arr[i];
                arr[i] = arr[first];
                arr[first] = temp;
                first++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

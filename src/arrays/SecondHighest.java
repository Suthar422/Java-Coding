package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SecondHighest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,11,5,10,9,1,11};

        int max = arr[0];
        int secondMax = arr[0];

        for(int i=1;i<arr.length;i++){
           if(arr[i]>max){
               secondMax = max;
               max = arr[i];
           }
           else if(arr[i]>secondMax && arr[i]<max){
               secondMax = arr[i];
           }
        }

        System.out.println(secondMax);

        //stream version
        Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
    }
}

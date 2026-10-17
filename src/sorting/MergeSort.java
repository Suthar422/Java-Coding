package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1, 5, 6};
        int low = 0;
        int high = arr.length - 1;
        mergeSort(arr, low, high);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {

        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
        }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high+1];

        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[left] = arr[left];
                left++;
            }
            else{
                temp[right] = arr[right];
                right++;
            }
        }

        while(left <= mid){
            temp[left] = arr[left];
            left++;
        }

        while(right <= high){
            temp[right] = arr[right];
            right++;
        }

        for(int i=low;i<=high;i++){
            arr[i] = temp[i];
        }


    }



}

package interfacedemo;


import java.util.*;
import java.util.stream.Collectors;

public class Polymorphism {

    public static void main(String[] args) {

        int[] arr =  {5, 3, 5 , 4, 8, 8, 8, 3, 5, 8};

        //   Sorted numbers: 0, 3,3, 5, 5,5, 8, 8, 8, 8
        Arrays.sort(arr);  //NlogN
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> missingNumber = new ArrayList<>();

     //   missing numbers:  2, 4, 6, 7, 9
         int max = Arrays.stream(arr).max().getAsInt();
         int min = Arrays.stream(arr).min().getAsInt();
         System.out.println(max);
         System.out.println(min);

         missingNumber.add(max+1);
         missingNumber.add(min-1);


//      Arrays.sort(arr);
         Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet()); //{3, 5, 8}
         //i =3 - 8
         for(int i = min+1; i < max; i++) {
                    if(!set.contains(i)) {
                        missingNumber.add(i);
                    }
             }

         System.out.println(missingNumber);







     //   Duplicate numbers: 3, 5, 8
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).forEach(System.out::println);





     //   Most Repeated number: 8

      Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).ifPresent(System.out::println);




        int[] arr1 =  {5, 3, 5 , 8, 8, 8, 3, 5, 8};



      Map<Integer, Integer> map = new HashMap<>();

      int max1 = Integer.MIN_VALUE;
      int min1 = Integer.MAX_VALUE;

        for (int j : arr1) {
            map.put(j, map.getOrDefault(j, 0) + 1);
//          max1 = Math.max(max1, arr[i]);
//          min1 = Math.min(min1, arr[i]);
            if (j > max1) max1 = j;
            if (j < min1) min1 = j;
        }

      System.out.println(map);

      System.out.println("=================================================");


      List<Integer> duplicate = new ArrayList<>();
      int mostRepeated = arr[0];
     // int count = 0;
        for(var entry: map.entrySet()){
            int value = entry.getValue();
            //duplicate
            if(value > 1){
                duplicate.add(entry.getKey());
            }

            //maximum repeated number without using streams
            if(value > mostRepeated){
                mostRepeated = entry.getKey();
            }

        }
        System.out.println(duplicate);
        System.out.println(mostRepeated);

        ArrayList<Integer> missingNumber1 = new ArrayList<>();

        for(int i = min1; i < max1; i++){
            if(!map.containsKey(i)){
                missingNumber1.add(i);
            }
        }

        System.out.println(missingNumber1);

    }
}




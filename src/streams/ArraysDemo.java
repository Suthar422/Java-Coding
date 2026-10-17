package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArraysDemo {

    public static void main(String[] args) {
        int arr[] = {1, 2, 1,4,9, 3, 3, 4, 5};

        //min
      int min = Arrays.stream(arr).reduce(Integer::min).orElse(0);
      System.out.println(min);
      System.out.println(Arrays.stream(arr).min().orElse(0));

      //max
        int max = Arrays.stream(arr).max().orElse(0);
        System.out.println(max);
        System.out.println(Arrays.stream(arr).reduce(Integer::max).orElse(0));

        //sum
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
        System.out.println(Arrays.stream(arr).reduce(0, (a,b) -> a+b));
        System.out.println(Arrays.stream(arr).reduce(Integer::sum).orElse(0));

        //unique
        int[] unique = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(unique));
        System.out.println(Arrays.stream(arr).distinct().count());

        //average
        double avg = Arrays.stream(arr).average().orElse(0);
        System.out.println(avg);

        //sort
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(sorted));


        //rray of Objects (e.g., String[] or Integer[])
      //For object arrays, use Arrays.stream(), apply sorted(Comparator.reverseOrder()), and collect the result using .toArray().

        //Array of Primitives (e.g., int[])
      //Since primitive streams (IntStream) do not accept custom comparators directly,
      // you first need to box the primitives into their wrapper objects (boxed()), apply the reverse comparator, and then unbox them back to primitives using
        //reverse
       int[] reversed = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder())
                       .mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(reversed));

        //frequency
      System.out.println(Arrays.stream(arr).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting())));


      int[] arr1 = {1, 1, 1};
      //2nd highest element
      Arrays.stream(arr1).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

      Optional<Integer> rd = Arrays.stream(arr1).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();

      if(rd.isPresent()) {
          System.out.println(rd.get());
      }
      else {
          System.out.println("Not found");
      }

      rd.ifPresent(System.out::println);
    }

}

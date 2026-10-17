package streams;

import java.util.*;
import java.util.stream.Collectors;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 1, 4, 9, 3, 3, 4, 5);

        //min
        int min = list.stream().min((a, b) -> (a - b)).orElse(0);
        System.out.println(min);
        System.out.println(list.stream().min(Integer::compare).orElse(0));
        System.out.println(list.stream().reduce(Integer::min).orElse(0));

        //max
        int max = list.stream().max((a, b) -> (a - b)).orElse(0);
        System.out.println(max);
        System.out.println(list.stream().mapToInt(i -> i).max().orElse(0));
        System.out.println(list.stream().max(Integer::compare).orElse(0));
        System.out.println(list.stream().reduce(Integer::max).orElse(0));

        //sum
        int sum = list.stream().reduce(0, (a, b) -> a + b).intValue();
        System.out.println(sum);
        System.out.println(list.stream().reduce(0, Integer::sum));
        System.out.println(list.stream().mapToInt(i -> i).sum());

        //average
        double avg = list.stream().mapToInt(i -> i).average().orElse(0);
        System.out.println(avg);


        //sort
        List<Integer> sorted = list.stream().sorted().toList();
        System.out.println(sorted);

        //reversed
        List<Integer> reversed = list.stream().sorted(Comparator.reverseOrder()).toList();

        System.out.println(reversed);

        //unique
        List<Integer> unique = list.stream().distinct().toList();
        System.out.println(unique);

        //frequency
        Map<Integer, Long> frequency = list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()));
        System.out.println(frequency);

        //duplicate
        List<Integer> duplicate = list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toList();

        System.out.println(duplicate);

        list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .entrySet().stream().filter(e-> e.getValue()>1).forEach(e-> System.out.println(e.getKey()));


        //using set
        Set<Integer> duplicates = list.stream()
                .filter(n -> Collections.frequency(list, n) > 1)
                .collect(Collectors.toSet());


        System.out.println(list.stream()
                .filter(n -> Collections.frequency(list, n) > 1).toList());

        //partition
        Map<Boolean, List<Integer>> partitioned = list.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println(partitioned);


//        List<Integer> list1 = List.of(1,1,1);

        //2nd highest element
       list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

       //3rd highest element
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().ifPresent(System.out::println);



        //even and odd
        Map<Boolean, List<Integer>> partitioned1 = list.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println(partitioned1);
















        //String List
        List<String> str = List.of("Jagdish", "Kavya", "Bhavya", "Navin", "Mohan", "Sangeeta", "Gopal", "Pushpa", "Kusum");

        //
        str.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst().ifPresent(System.out::println);





    }
}
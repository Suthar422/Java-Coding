package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllInOneConcepts {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 9, 3, 3, 4, 5};
        List<Integer> list = List.of(1, 2, 1, 4, 9, 3, 3, 4, 5);

        //min
        System.out.println("minimum number is: ");
        System.out.println(Arrays.stream(arr).min().orElse(0));
        System.out.println(list.stream().mapToInt(i -> i).min().orElse(0));
        //list take comparator
        System.out.println(list.stream().min(Integer::compare).orElse(0));
        System.out.println(list.stream().min((a, b) -> (a - b)).orElse(0));
        System.out.println(list.stream().min(Comparator.comparingInt(i->i)).orElse(0));

        //using reduce same in list and array
        System.out.println(list.stream().reduce(Integer::min).orElse(0));
        System.out.println(Arrays.stream(arr).reduce(Integer::min).orElse(0));

        //max
        System.out.println("maximum number is: ");
        System.out.println(Arrays.stream(arr).max().orElse(0));
        System.out.println(list.stream().mapToInt(i -> i).max().orElse(0));
        //list take comparator
        System.out.println(list.stream().max(Integer::compare).orElse(0));
        System.out.println(list.stream().max((a, b) -> (a - b)).orElse(0));
        System.out.println(list.stream().max(Comparator.comparingInt(i -> i)).orElse(0));

        //using reduce same in list and array
        System.out.println(list.stream().reduce(Integer::max).orElse(0));
        System.out.println(Arrays.stream(arr).reduce(Integer::max).orElse(0));

        //sum
        System.out.println("sum of numbers is: ");
        System.out.println(Arrays.stream(arr).sum());
        System.out.println(list.stream().mapToInt(i -> i).sum());

        //using reduce same in list and array
        System.out.println(Arrays.stream(arr).reduce(Integer::sum).orElse(0));
        System.out.println(list.stream().reduce(Integer::sum).orElse(0));


        //Average
        System.out.println("average of numbers is: ");
        System.out.println(Arrays.stream(arr).average().orElse(0));
        System.out.println(list.stream().mapToInt(i -> i).average().orElse(0));

        //other way calculate sum of numbers then divide by number of elements


        //unique
        System.out.println("unique numbers are: ");
        System.out.println(Arrays.toString(Arrays.stream(arr).distinct().toArray()));  //covert it to ToString array
        System.out.println(list.stream().distinct().toList());
        System.out.println(list.stream().collect(Collectors.toSet()));  //default it sorted

        //sorted
        System.out.println("sorted numbers are: ");
        System.out.println(Arrays.toString(Arrays.stream(arr).sorted().toArray()));
        System.out.println(list.stream().sorted().toList());
        System.out.println(list.stream().sorted(Comparator.comparingInt(Integer::intValue)).toList());  //default it sorted in ascending order

        //sorted in reverse order
        System.out.println("sorted numbers in reverse order are: ");
        System.out.println(Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).toList());
        //if you want array
        int[] rev = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(rev));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());
        System.out.println(list.stream().sorted((a, b) -> (b - a)).toList());


        //2nd highest number
        System.out.println("2nd highest number is: ");
        System.out.println(Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0));
        System.out.println(list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0));


        // frequency
        System.out.println("frequency of numbers are: ");
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.println(list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting())));


        //odd and even
        System.out.println("Odd and Even using partitioning: ");
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(n -> n%2 == 0)));
        System.out.println(list.stream().collect(Collectors.partitioningBy(n -> n%2 == 0)));



        //Filter odd numbers from a list and square them.
        System.out.println("Filter odd numbers from a list and square them: ");
        System.out.println(list.stream().filter(n -> n%2 != 0).map(n -> n*n).toList());



        System.out.println("=========================== String  ======================= ");


        List<String> str = Arrays.asList("Pune", "Jaipur", "Jodhpur", "Pune", "Surat", "Jaipur", "Mumbai", "Surat", "Ahmedabad", "Indore", "Chandigarh", "Aurangabad");


        System.out.println("Unique");
        System.out.println(str.stream().distinct().toList());


        System.out.println("convert it to upper case");
        System.out.println(str.stream().map(String::toUpperCase).toList());

        System.out.println("string starting with A");
        System.out.println(str.stream().filter(s -> s.startsWith("A")).toList());

        System.out.println("Minimum length of string: ");
        System.out.println(str.stream().min(Comparator.comparing(String::length)).get());
        System.out.println(str.stream().min((a,b)->a.length()-b.length()));


        System.out.println("Maximum length of string: ");
        System.out.println(str.stream().max(Comparator.comparing(String::length)).get());
        System.out.println(str.stream().max((a,b)->a.length()-b.length()));

        System.out.println("Joining string using join: ");
        System.out.println(String.join(",", str));
        System.out.println(str.stream().collect(Collectors.joining(",")));


        System.out.println("Sorting string using sorted: ");
        System.out.println(str.stream().sorted().toList());

        System.out.println("Sorting string in reverse order using sorted: ");
        System.out.println(str.stream().sorted(Comparator.comparing(String::toString).reversed()).toList());
        System.out.println(str.stream().sorted(Comparator.comparing(a -> a.toString()).reversed()).toList());
        System.out.println(str.stream().sorted((a,b) -> b.compareTo(a)).toList());

        System.out.println("Sorting string based on length: ");
        System.out.println(str.stream().sorted(Comparator.comparing(String::length)).toList());
        System.out.println(str.stream().sorted(Comparator.comparingInt(a -> a.length())).toList());
        System.out.println(str.stream().sorted((a,b) -> Integer.compare(a.length(), b.length())).toList());


        System.out.println("Reverse sorting string based on length: ");
        System.out.println(str.stream().sorted(Comparator.comparingInt(String::length).reversed()).toList());
        System.out.println(str.stream().sorted(Comparator.comparing(a -> a.toString().length()).reversed()).toList());
        System.out.println(str.stream().sorted((a,b) -> Integer.compare(b.length(), a.length())).toList());


        System.out.println("frequency of string: ");
        System.out.println(str.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


        System.out.println("Find All Duplicate Words");
        System.out.println(str.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey).toList());
















    }
}

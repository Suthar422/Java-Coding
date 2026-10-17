package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class StringDemo {
    public static void main(String[] args) {
        String str = "I like to hangout";
        System.out.println(str);

        String[] words = str.split(" ");

        Arrays.stream(words).mapToInt(String::length).max().ifPresent(System.out::println);



        //print the longest word length using streams
        System.out.println(Arrays.stream(str.split(" ")).mapToInt(String::length).max().getAsInt());



        //print the longest word using streams
        System.out.println(Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).get());




        String str1 = "geeksforgeeks";

        //find first non repeating character
        str1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .map(e->e.getKey())
                .findFirst()
                .ifPresent(System.out::println);



        System.out.println(str1.chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.groupingBy(c->c, Collectors.counting())));

    }
}

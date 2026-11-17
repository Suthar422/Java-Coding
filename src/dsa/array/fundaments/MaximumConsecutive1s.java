package dsa.array.fundaments;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaximumConsecutive1s {

    public static void main(String[] args) {

//Traditional Java
        String str = "swiss";

        Map<Character,Integer> map = new HashMap<>();

        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);

//Stream
        Map<Character,Long> result =
                str.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));

        System.out.println(result);

    }
}

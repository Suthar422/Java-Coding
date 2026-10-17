package string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortBasedOnFrequency {

    public static void main(String[] args) {
        String str = "geeksforgeeks";

        Map<Character,Integer> map = new HashMap<>();

        for(char c:str.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        System.out.println(map);

        //sort based on frequency
        map.entrySet().stream()
                .sorted((e1, e2) ->
                        e2.getValue()-e1.getValue()).forEach(System.out::println);
    }

}

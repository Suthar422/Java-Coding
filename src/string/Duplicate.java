package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicate {

    public static void main(String[] args) {
        List<String> str = Arrays.asList("Pune", "Jaipur", "Jodhpur", "Pune", "Surat", "Jaipur", "Mumbai", "Surat", "Ahmedabad", "Indore", "Chandigarh", "Aurangabad");


        Set<String> seen = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for(String s: str){
            if(!seen.add(s)){   // add() returns false if already present
                duplicate.add(s);
            }
        }

        System.out.println(seen);
        System.out.println(duplicate);

        // Stream version
        Set<String> seen1 = new HashSet<>();
        Set<String> duplicates = str.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());

        System.out.println(duplicate);
    }
}

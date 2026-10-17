package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonReapeatingChar {

    public static void main(String[] args) {

        String str = "jajaagdish";


        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }


        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}

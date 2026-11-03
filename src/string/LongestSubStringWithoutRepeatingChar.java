package string;

import java.util.HashMap;
import java.util.Map;


//print longest substring without repeating characters, not maximum length
public class LongestSubStringWithoutRepeatingChar {

    public static void main(String[] args) {

        String str = "bhavyamohanlalsuthar";

        Map<Character, Integer> map = new HashMap<>();

        int l=0, r=0, max=0;
        while(r<str.length()){

            while(map.containsKey(str.charAt(r))){
                map.remove(str.charAt(l));
                l++;
            }

            map.put(str.charAt(r), r);

            int len = r-l+1;

            max = Math.max(max, len);

            r++;
        }

        System.out.println(max);
        //print substring

    }
}

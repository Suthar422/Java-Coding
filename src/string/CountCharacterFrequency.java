package string;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterFrequency {
    public static void main(String[] args) {
        String str = "hello";
     //   int[] freq = new int[256];

        int[] freq = new int[26];
//        for(int i=0;i<str.length();i++){
//        //    freq[str.charAt(i)]++;
//
//            freq[str.charAt(i)-'a']++;
//        }
//
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }

        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                System.out.println((char)i+" "+freq[i]);
            }
        }

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }
        System.out.println(map);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        for(var entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}

package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bca";
//        str1.equals(str2);
        if(str1.length()!=(str2.length())) {
            System.out.println("Not Anagram");
            return;
        }

        int[] charFreq = new int[26];

        for(int i=0;i<str1.length();i++){
            charFreq[str1.charAt(i)-'a']++;
            charFreq[str2.charAt(i)-'a']--;
        }

        for(int cnt : charFreq) {
            if(cnt != 0){
            System.out.println("Not Anagram");
            return;
            }
        }

        System.out.println("Anagram");



        Map<Character, Integer> map = new HashMap<>();
        for(char c: str1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: str2.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)-1);


        }
        for (var entry: map.entrySet()){
            if(entry.getValue() !=0 ){
                System.out.println("Not Anagram");
            }
        }

        System.out.println(map);

        String s1 = "Jagdish";
        String s2 = "Jagdish";

        System.out.println(s1);
        System.out.println(s2);
        s1.toLowerCase();
        s2.toLowerCase();
        s1 = "kk";
        System.out.println(s1);
        System.out.println(s2);

       char[] c1 = s1.toCharArray();
       char[] c2 = s2.toCharArray();

       Arrays.sort(c1);
       Arrays.sort(c2);

       System.out.println(Arrays.equals(c1, c2));



    }
}

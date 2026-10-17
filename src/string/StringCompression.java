package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(str);

        // a2b1c5a3
        StringBuilder compressedStr = new StringBuilder();
        int count = 1;
        for(int i=1;i<= str.length();i++){
           if( i < str.length() && str.charAt(i)==str.charAt(i-1)){
               count++;
           }
           else{
               compressedStr.append(str.charAt(i-1)).append(count);
               count = 1;
           }
        }

        System.out.println(compressedStr.toString());


    }
}

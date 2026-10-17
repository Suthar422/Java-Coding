package string;

public class StringExpansion {

    public static void main(String[] args) {
        String str = "a3b2c4a2";

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);

            if(Character.isDigit(c)){
                for(int j=0; j<Character.getNumericValue(c); j++){
                    sb.append(str.charAt(i-1));
                }
            }
        }

        System.out.println(sb);
    }
}

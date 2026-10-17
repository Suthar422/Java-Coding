package string;

public class Reverse {
    public static void main(String[] args) {
        String str = "Hello, World!";

        String rev = new StringBuilder(str).reverse().toString();

        StringBuffer sb = new StringBuffer(str);
        String rev2 = sb.reverse().toString();
        System.out.println(rev);
        System.out.println(rev2);
        sb.append("Geeks");

        String s ="";
        for(int i=str.length()-1;i>=0;i--){
            s+=str.charAt(i);
        }
        System.out.println(s.trim());

        String s1 = "I Love India";
        StringBuilder sb1 = new StringBuilder();
        String[] sr = s1.split(" ");
        for(int i=sr.length-1;i>0;i--){
           sb1.append(sr[i]).append(" ");
        }
        sb1.append(sr[0]);

        System.out.println(sb1.toString());

    }
}

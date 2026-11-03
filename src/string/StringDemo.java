package string;

public class StringDemo {

    public static void main(String[] args) {


        String s1= new String("Hello");
        String s2 = new String("Hello");

        String s3 = "hello";
        String s4 = "HELLO";


        System.out.println(s3.equals(s4.toLowerCase()));

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

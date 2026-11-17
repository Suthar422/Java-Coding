package pattern;


/*
12344321
123**321
12****21
1******1
 */

public class Pattern1 {

    public static void main(String[] args) {

        for(int i=0; i<4; i++){

            for(int j=1; j<=4-i; j++){
                System.out.print(j);
            }

            for(int k=0; k<i; k++)System.out.print("*");

            //mirror this code
            for(int k=0; k<i; k++)System.out.print("*");

            for(int j=4-i; j>0; j--){
                System.out.print(j);
            }

            System.out.println();

        }
    }
}

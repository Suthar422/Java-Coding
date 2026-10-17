package streams;

public class NextPalindrome {


    private static String getNextPalindrome(String str) {
        int n = str.length();
        char[] digits = str.toCharArray();

        //check if all digits are 9's (eg, 99 -> 1001)
        if(isAll9s(digits))
            return "1" + "0".repeat(n) + "1";


        //separate indices for mirroring
        int mid = n / 2;
        int i = mid-1;
        int j = (n % 2 == 0) ? mid : mid+1;

        // Skip middle digits that are already identical
        while(i >= 0 && digits[i] == digits[j]) {
            i--;
            j++;
        }


        boolean leftIsSmaller = false;
        // If they don't match, determine if the left side needs an increment
        if (i < 0 || digits[i] < digits[j]) {
            leftIsSmaller = true;
        }

        // Copy the left half to the right half
        while (i >= 0) {
            digits[j] = digits[i];
            j++;
            i--;
        }

        int carry = 1;
        boolean flag = false;
        while (i >= 0) {
            int currentDigit = digits[i] - '0' + carry;
            carry = currentDigit / 10;
            digits[i] = (char) ((currentDigit % 10) + '0');

            if(leftIsSmaller){
                int c= Character.getNumericValue(digits[mid]) + 1;
                System.out.println(digits[mid]);
                digits[mid] = Character.toString(c).charAt(0);

                System.out.println(digits[mid]);
                flag = true;
            }
            digits[j] = digits[i]; // mirror
            i--;
            j++;
        }

        String nextPalindrome = new String(digits);

//        if(){
//            return new String("1" + "0".repeat(n) + "1");
//        }


        return new String(digits);
    }


    private static boolean isAll9s(char[] digits) {
        for(char digit : digits)
            if(digit != '9')
                return false;
        return true;
    }


    public static void main(String[] args) {
        String str = "42354";


        String nextPalindrome = getNextPalindrome(str);
        System.out.println("Next palindrome is: " + nextPalindrome);
    }

}

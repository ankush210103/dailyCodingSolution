class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if(x<0){
            x = -x;
            negative = true;

        }
        int reverse = 0;
        while (x != 0) {
            int digit = x % 10;

            // Check for overflow before updating reverse
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow case
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow case
            }

            reverse = reverse * 10 + digit;
            x = x / 10;
        }

       
         if(negative){
            return -reverse;
         }else{
            return reverse;
         }
    }
}
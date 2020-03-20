package com.epi.hashtables;

public class StringHashFunction {
    /**
     * 1. Examines all characters
     * 2. Is rolling hash function
     * 3. Should have a large range of values
     * @param str
     * @param modulus
     * @return
     */
    public static int stringHash(String str, int modulus){
        int kMultiply = 997;
        int val = 0;
        for (int i = 0; i<str.length(); i++){
            //Get each character. This means we are examining each character
            char c = str.charAt(i);
            //multiply each value to 997 to create a difference of 997 values between two hash codes
            //This makes it a hash-function with a large range of values
            val = (val * kMultiply + c);
            //We divide the hash-code with a modulus
            //This makes this hash-function rolling
            val =  val % modulus;
        }
        return val;
    }
}

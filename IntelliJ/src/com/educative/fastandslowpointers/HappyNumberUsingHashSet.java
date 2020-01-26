package com.educative.fastandslowpointers;

import java.util.HashSet;

public class HappyNumberUsingHashSet {
    //This will time out.
    public static boolean isNumberHappy(int num){
        HashSet<Integer> set = new HashSet<>();
        int sum = calculateSumOfSquares(num);
        while(sum!=1){
            sum = calculateSumOfSquares(sum);
            if(set.contains(sum))
                return false;
        }
        return true;
    }

    private static int calculateSumOfSquares(int num) {
        int temp = num;
        int sum = 0;
        while(temp>0){
            sum = sum + (temp%10);
            temp = temp/10;
        }
        return sum;
    }
}

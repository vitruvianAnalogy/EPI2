package com.educative.fastandslowpointers;

public class HappyNumberUsingFastSlowPointers {
    public static boolean find(int num){
        int slow = num, fast = num;

        do{
            slow = findSum(slow);
            fast = findSum(findSum(fast));
        }while(slow!=fast);

        return slow==1;
    }

    private static int findSum(int num) {
        int sum = 0;
        while(num!=0){
            int digit = num%10;
            sum = sum + (digit*digit);
            num = num/10;
        }
        return sum;
    }

}

package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithOnesAfterReplacement {
    public static int findLength(int[] arr, int k){
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;
        int onesCount = 0;
        for(int windowEnd=0; windowEnd<arr.length; windowEnd++){
            if(arr[windowEnd] == 1){
                onesCount++;
            }

            /**
             * windowEnd - windowStart means the length of the substring
             * onesCount is the number of ones between them
             * rest of is number of zeroes
             * when number of zeroes become more than k
             * if we have more than k zeroes we try to shrink the window
             */
            if(windowEnd-windowStart+1-onesCount > k){
                //we shrink by moving windowStart by 1
                //but if windowStart was 1 we also keep track
                //of the number of ones.
                if(arr[windowStart]==1){
                    onesCount--;
                }
                windowStart++;
            }
            //everytime the number of zeros become more than k, we decrement it
            //and make it equal to k and calculate that length
            //otherwise it stays less than k, but never more than k
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}

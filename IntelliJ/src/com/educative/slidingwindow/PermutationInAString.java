package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {
    public static boolean contains(String str, String pattern){
        if(str.length()<pattern.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;

        //O(m) where m is length of the pattern
        //store all the letters present in the pattern in a map
        for(int i=0; i<pattern.length(); i++){
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i),0)+1);
        }
        /**
         * We can find all permutations and then compare them with the string
         * but the timecomplexity will become n! which is not very good.
         */
        int howManyDistinctElementsMatched = 0;
        for(int windowEnd=0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar)-1);
                if(map.get(rightChar)==0)
                    howManyDistinctElementsMatched++;
            }
            //if we have encountered all the elements in the pattern
            if(howManyDistinctElementsMatched == map.size()){
                return true;
            }
            //if windowEnd index is equal to or greater than last index of pattern
            //in cases like abacc where pattern is acc, we match first a
            //but when first b doesn't work out, we keep that match until our sliding window
            //gets bigger than pattern and then we shrink the window from the first a
            //and hence have the second a as a consideration.
            if(windowEnd >= pattern.length() - 1){
                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar) == 0){
                        howManyDistinctElementsMatched--;
                    }
                    map.put(leftChar, map.get(leftChar)+1);
                }
            }
        }
        return false;
    }
}

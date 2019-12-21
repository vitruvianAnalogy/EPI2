package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {
    public static int findLength(String str, int k){
        //everytime we see a gap of k between identical letters, we calculate that length
        //or everytime we encounter a letter, we have to see if after a k element gap
        //that letter reoccur.

        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int windowEnd=0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar,0)+1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(rightChar));

            //If we we have the opportunity to replace more than k letters, then we shrink the window
            if(windowEnd - windowStart + 1 - maxRepeatLetterCount > k){
                char leftChar = str.charAt(windowStart); //shrink windowStart
                map.put(leftChar, map.get(leftChar)-1);//since sliding window has moved
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }
}

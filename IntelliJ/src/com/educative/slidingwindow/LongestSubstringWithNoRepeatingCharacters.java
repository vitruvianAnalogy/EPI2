package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoRepeatingCharacters {
    /**
     * Time complexity is O(K) where k is the number of distinct characters
     * @param str
     * @return
     */
    public static int findLength(String str){
        int maxLength = Integer.MIN_VALUE;
        //the value would be the location of the character
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            //just the existence of a character in map
            //means that the letter is getting repeated
            if(map.containsKey(c)){
                //whichever is ahead
                //windowStart or one ahead from the location of the character
                windowStart = Math.max(windowStart, map.get(c)+1);
            }
            //calculate the max length from the windowStart
            maxLength = Math.max(maxLength, i-windowStart+1);
            //put the new location of the character
            map.put(c, i);
        }
        return maxLength;
    }
}

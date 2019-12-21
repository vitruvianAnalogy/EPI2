package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {
    //I THINK THIS PROBLEM ASSUMES THAT a pattern like AABC will never happen
    public static String smallestSubString(String str, String pattern){
        //if pattern is bigger than str then we know,
        // all the characters of the pattern can't be inside the string
        if(pattern.length() > str.length())
            return "";

        //populate the map with the character frequency
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i),0)+1);
        }

        int minLength = str.length()+1;
        int windowStart = 0;
        int countEveryMatching = 0;
        int substringStartIndex = 0;
        String smallestString ="";

        //iterate through each end
        //windowStart is at 0
        for(int windowEnd=0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                //count every occurrence of a character,
                // so 'aa' means countEveryMatching will increment by 2, not 1
                if (map.get(rightChar) >= 0) {
                    countEveryMatching++;
                }
            }

            //since we are counting every matching
            //we can compare the number of matching with
            //pattern length
            while(countEveryMatching == pattern.length()){
                if(minLength > windowEnd-windowStart+1){
                    minLength = windowEnd-windowStart+1;
                    substringStartIndex = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)){
                    //this problem assumes that a pattern like 'aabc' will never happen
                    //meaning we'll only decrement 'countEveryMatching'
                    //when a pattern character's last occurrence from the window is leaving
                    //for instance if in a window there was 'aa', we won't care
                    // if the first 'a' leaves the window
                    //but we will care if the second 'a' leaves the window
                    if(map.get(leftChar)==0)
                        countEveryMatching--;
                    map.put(leftChar, map.get(leftChar)+1);
                }
            }
        }
        //if we don't find a pattern then minLength will never get lower than the initial value
        return minLength>str.length()? "": str.substring(substringStartIndex, substringStartIndex+ minLength);
    }
}

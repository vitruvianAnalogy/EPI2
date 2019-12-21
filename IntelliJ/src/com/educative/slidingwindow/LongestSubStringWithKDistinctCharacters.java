package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctCharacters {
    //Not Correct
    public static int findLength(String str, int k){
        int length = str.length();
        //iterate through the string, while keeping track of number of distinct characters
        int numberOfDistinctElements = 1;
        int startIndex = 0;
        int change = 0;
        int longestLength = Integer.MIN_VALUE;
        for(int i=1; i<length; i++){
            if(str.charAt(i) != str.charAt(i-1)){ //this condition is incorrect, it just compares with previous element.
                numberOfDistinctElements++;
                change = i;
            }
            //greater than k, because we need to know when a substring stop following
            //the condition
            if(numberOfDistinctElements>k){
                longestLength = Math.max(longestLength, i-startIndex);
                startIndex = change;
                numberOfDistinctElements--;
            }
        }
        return longestLength;
    }
    public static int findLengthUsingHashMap(String str, int k){
        if(str == null || str.length()==0 || str.length() < k)
            throw new IllegalArgumentException();
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd<str.length(); windowEnd++){
            //start counting each char's frequency
            char rightChar = str.charAt(windowEnd);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar,0) + 1);

            //When the map has more than k distinct characters
            //we know we have counted all distinct elements
            while(charFreqMap.size()>k){
                //iterate from start until when the numberOfDistinct character
                //fall under k
                char leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar)-1);
                if(charFreqMap.get(leftChar)==0){
                    //when charFreqMap size falls below 'k'
                    //we know we don't have k distinct elements anymore
                    //we have calculated the string with distinct elements
                    charFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            //we'll keep calculating the maxLength so far.
            //+1 because we incremented windowStart one extra time at 53,
            //right after 51 where we removed the leftmost distinct element from the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}

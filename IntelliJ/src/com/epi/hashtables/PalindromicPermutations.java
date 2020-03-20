package com.epi.hashtables;

import java.util.HashMap;
import java.util.Map;

public class PalindromicPermutations {
    /**
     * Palindromic permutations would mean that each letter occurs twice
     */
    public static boolean canBePalindrome(String word){
        if(word.length() == 0)
            return true;
        //We can iterate through and find the list of letters and their frequency
        //Assuming that we aren't just using a-z, we have a lot of letters
        //We can story each letter occurence in a list and then whenever we find another occurrence
        //we increase the frequency.
        //Since list are bad for lookup, we need to use hashmap, because we need to keep track of frequencies
        //as well

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            Character character = word.charAt(i);
            Integer freq = map.get(character);
            if(freq.intValue() == 0){
                map.put(character, new Integer(1));
            } else {
                map.put(character, new Integer(freq.intValue()+1));
            }
        }

        int moreThanOne = 0;
        for(Integer value : map.values()){
            if(value%2==1){
                moreThanOne++;
            }
        }
        if(moreThanOne>1)
            return false;
        else
            return true;
    }
}

package com.epi.hashtables;

import java.util.HashMap;
import java.util.Map;

public class AnonymousLetter {
    Map<Character, Integer> letterMap = new HashMap<>();
    Map<Character, Integer> magazineMap = new HashMap<>();
    /**
     * freq of alphabets in letter is <= freq of alphabets in magazine
     * @param letter
     * @param magazine
     * @return
     */
    public boolean isAnonymousLetterConstructible(String letter, String magazine){
        for(int i=0; i<letter.length(); i++){
            Integer freq = letterMap.get(letter.charAt(i));
            if(freq == null || freq.intValue() == 0){
                letterMap.put(letter.charAt(i), 1);
            } else
                letterMap.put(letter.charAt(i), freq.intValue()+1);
        }

        for(int i=0; i<magazine.length(); i++){
            Integer freq = magazineMap.get(magazine.charAt(i));
            if(freq == null || freq.intValue() == 0){
                magazineMap.put(magazine.charAt(i), 1);
            } else
                magazineMap.put(magazine.charAt(i), freq.intValue()+1);
        }

        for(int i=0; i<letterMap.size(); i++){

        }
    }
}

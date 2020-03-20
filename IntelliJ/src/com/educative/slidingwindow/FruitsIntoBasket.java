package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Same problem as "longest substring with k distinct characters". Only difference 'k' is 2
 */
public class FruitsIntoBasket {
    public static int method(char[] trees){
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLength = 0;

        //Maximum number of fruits in each basket - each basket can have only type of character
        //Both baskets should have fruits

        //Find the size of the largest continuous block such that you have the two most frequent letters
        for(int i=0; i<trees.length; i++){
            char leftChar = trees[i];
            map.put(leftChar, map.getOrDefault(leftChar,0)+1);

            while(map.size()>2){
                char rightChar = trees[start];
                map.put(rightChar, map.get(rightChar) -1);
                if(map.get(rightChar) == 0){
                    map.remove(rightChar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, i-start+1);

        }
        return maxLength;
    }
}

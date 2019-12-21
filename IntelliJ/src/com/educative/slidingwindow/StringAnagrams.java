package com.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> anagramIndexes(String str, String pattern){
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            map.put(pattern.charAt(i), map.get(pattern.charAt(i))+1);
        }

        int windowStart = 0;
        int numberOfElements = 0;

        for(int windowEnd=0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar)-1);
                if(map.get(rightChar)==0)
                    numberOfElements++;
            }
            if(numberOfElements==map.size()){
                list.add(windowStart);
            }

            if(windowEnd >= pattern.length()-1){
                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)==0){
                        numberOfElements--;
                    }
                    map.put(leftChar, map.get(leftChar)+1);
                }
            }

        }
        return list;

    }
}

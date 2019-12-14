package com.epi.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntriesInAnArray {
    public static int findNearestRepetition(List<String> words){
        Map<String, Integer> wordToLatestIndex = new HashMap<>();
        int nearestRepeatedDistance = Integer.MAX_VALUE;

        for(int i=0; i<words.size(); i++){
            String word = words.get(i);
            Integer distance = wordToLatestIndex.get(word);
            if (distance != null){
                nearestRepeatedDistance = Math.min(nearestRepeatedDistance, i-distance);
            }
            wordToLatestIndex.put(word, i);
        }

        return nearestRepeatedDistance;
    }
}

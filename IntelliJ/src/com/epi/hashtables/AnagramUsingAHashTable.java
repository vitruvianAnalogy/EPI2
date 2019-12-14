package com.epi.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramUsingAHashTable {
    public static List<List<String>> returnListOfGroupsOfAnagrams(List<String> dictionary){
        Map<String, List<String>> map = new HashMap<>();
        List<String> group = new ArrayList<>();
        for(int i=0; i<dictionary.size(); i++){
            String sortedString = sort(dictionary.get(i));
            map.putIfAbsent(sortedString, group);
            map.get(sortedString).add(dictionary.get(i));
        }

        List<List<String>> anagramGroups = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            if(entry.getValue().size() >= 2){
                anagramGroups.add(entry.getValue());
            }
        }
        return anagramGroups;
    }

    private static String sort(String s) {
        //return sorted string
        return "";
    }
}

package com.epi.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnagramWithoutUsingHashTables {
    /**
     * You sort each string and store them. mlogm - where m is the length of the longest string
     * You compare each string with every other string n^2 - where n is total number of string
     * We are sorting every time we compare
     * The total time complexity = n^2 * mlogm
     * @param dictionary
     * @return
     */
    private static List<List<String>> returnsGroupOfAnagramsUsingSorting(List<String> dictionary){
        List<List<String>> listOfGroups = new ArrayList<>();
        for(int i=0; i<dictionary.size(); i++){
            List<String> group = new ArrayList<>();
            for(int j=i+1; j<dictionary.size(); j++){
                if(areAnagrams(dictionary.get(i),dictionary.get(j))){
                    group.add(dictionary.get(j));
                }
            }
            if(group.size()>0){
                group.add(dictionary.get(i));
            }
            listOfGroups.add(group);
        }
        return listOfGroups;
    }

    private static boolean areAnagrams(String s, String s1) {
        return (sort(s).equalsIgnoreCase(sort(s1)));
    }

    private static String sort(String s1) {
        //todo - merge sort s1
        return "";
    }

}

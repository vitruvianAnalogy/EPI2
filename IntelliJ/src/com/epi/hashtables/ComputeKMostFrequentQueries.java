package com.epi.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeKMostFrequentQueries {
    //Given an array of strings, compute the strings that come up most often

    //Brute Force - sorts the map
    public List<String> returnKMostFrequent(String[] array){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i< array.length; i++){
            map.putIfAbsent(array[i], 0);
            int j = map.get(array[i]);
            map.put(array[i],++j);
        }
        map = sort(map);
        List<String> list = new ArrayList<>();
        for( Map.Entry<String, Integer> value : map.entrySet()){
            list.add(value.getKey());
        }
        return list;
    }

    private Map<String, Integer> sort(Map<String, Integer> map) {
        //Todo
        return map;
    }

}

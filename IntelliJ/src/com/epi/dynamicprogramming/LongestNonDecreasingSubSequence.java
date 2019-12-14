package com.epi.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNonDecreasingSubSequence {
    public static int lengthOfLongestNonDecreasingSubSequence(List<Integer> numbers){
        Integer[] memory = new Integer[numbers.size()];
        Arrays.fill(memory, 1);
        for(int i=0; i<numbers.size(); i++){
            for(int j=0; j<i; j++){
                if(numbers.get(i) >= numbers.get(j)){
                    memory[i] = Math.max(memory[i],1 + memory[j]);
                }
            }
        }
        return Collections.max(Arrays.asList(memory));
    }
}

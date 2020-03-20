package com.epi.greedy.invariants;

import java.util.*;

public class FindTheMajorityElement {
    public static String findTheMajorBruteForce(List<String> elements){
        Map<String, Integer> map = new TreeMap<>();
        int max = 0;
        String maxString = "";
        for(int i=0; i<elements.size(); i++){
            map.putIfAbsent(elements.get(i), 0);
            int sum = map.get(elements.get(i));
            map.put(elements.get(i),++sum);
            max = Math.max(sum, max);
            if(max==sum){
                maxString = elements.get(i);
            }
        }
        return maxString;
    }

    /**
     * O(n) time complexity
     * Go from left to right
     * If frequence/count is zero then increment the freq and store the character
     * if next element is different then decrement the count
     * if next element is same then increment the count
     *
     * If the majority alphabet/word exists in the sequence, we'll get the word
     * If there is no majority we'll still get a letter, but we wouldn't know whether there is a majority or not
     *
     * So to know whether there is a majority or not, we'll have to do a second pass
     * to see how many times that string showed up to fathom whether it is majority or not
     * If the string showed by more than 1/2 times then it is clearly a majority
     *
     *
     * So basically this algo only returns a string that is "majority or equal frequency than the rest"
     * @param sequence
     * @return
     */
    public static String findMajorityElement(Iterator<String> sequence){
        String candidate = "";
        String iter;
        int count = 0;
        while(sequence.hasNext()){
            iter = sequence.next();
            if(count == 0){
                candidate = iter;
                count = 1;
            } else if(candidate.equals(iter)){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

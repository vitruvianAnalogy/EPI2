package com.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given : All the words are of same length. That means we can jump the lengths if need be
 * Assuming that the string is made of the words
 * Assuming that one word only occurs once in the list (not the string)
 *
 *
 * Time complexity - O(N * M * wordLength)
 * Why not just N*M?
 * It is because we are using the method "substring" which has the time complexity of O(wordLength)
 * and since it used inside the inner loop, we get O(M*wordLength)
 * and hence together with outer loop it becomes O(N * M * wordLength)
 *
 *
 * Space complexity - O(N+M)
 * we will be storing all the words (M) in hashmap
 * in worst case i.e. every word is of length 1 and every index fulfills the condition O(N)
 */
public class WordsConcatenation {
    public static List<Integer> findAllStartingIndices(String str, String[] words){
        List<Integer> list = new ArrayList<>();
        if(words.length==0)
            return list;

        //We know all words are of equal length
        int wordLength = words[0].length();
        int wordsCount = words.length;

        Map<String, Integer> map = new HashMap<>();
        //Assuming one word only occurs once in the list of words
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        //lastValidIndex is the index after which no new list of words can be found
        //because the length of the remaining string would be less than the length
        //of the total words' length.
        int lastValidIndex = str.length() - (wordsCount*wordLength);
        for(int i =0; i<=lastValidIndex; i++){
            Map<String, Integer> wordsSeen = new HashMap<>();
            for(int j=0; j< wordsCount; j++){
                int wordIndex = i+j*wordLength;
                //On each iteration we'll find the next word
                String word = str.substring(wordIndex, wordIndex+wordLength);
                //if the next word is not valid we break, meaning we go to the next startIndex
                if(!map.containsKey(word)){
                    break;
                }
                //If the next word is valid, we put it in the wordsSeen map
                wordsSeen.put(word, wordsSeen.getOrDefault(word,0)+1);

                //If we have seen it more than we want it to be seen then we move to the next iteration
                //not needing this i, therefore we break
                if(wordsSeen.get(word)> map.getOrDefault(word,0)){
                    break;
                }

                //if we have are in the last iteration of j
                //then it means we have seen all the words we wanted to see
                //and we add that 'i' or startIndex
                if(j+1==wordsCount){
                    list.add(i);
                }
            }
        }

        return list;
    }
}

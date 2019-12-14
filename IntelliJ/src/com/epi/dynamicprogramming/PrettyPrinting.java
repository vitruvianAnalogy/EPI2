package com.epi.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Messiness of a line ending with b blank characters is b^2
 *
 * Input - A string of words
 * Words are separated by single blanks
 * Decompose input into lines such that
 * 1. No word is split
 * 2. messiness is minimized
 *
 * Each line can hold no more than a specified number of characters
 */
public class PrettyPrinting {

    public static int minimumMessiness(List<String> words, int length){
        //keeps minimum messiness score for each word
        int[] minimumMessiness = new int[words.size()];
        Arrays.fill(minimumMessiness, Integer.MAX_VALUE);

        //first word
        int numRemainingBlanks = length - words.get(0).length();
        minimumMessiness[0] = numRemainingBlanks * numRemainingBlanks;

        //for rest of the words
        for(int i =1; i<words.size(); i++){
            //calculate for the ith word, how much space is left after
            //ith word uses the blanks
            /**
             * keep in mind we are only calculating the messiness of the
             * ith word alone. the words before it aren't getting used
             * since we are using
             * numRemainingBlanks = length - words.get(i).length();
             * instead of
             * numRemainingBlanks = numRemainingBlanks - words.get(i).length();
             */
            numRemainingBlanks = length - words.get(i).length();
            //calculate the messiness considering that rest of the spaces are not used
            // that would be the highest messiness possible
            minimumMessiness[i] = minimumMessiness[i-1] + numRemainingBlanks*numRemainingBlanks;


            /**
             * Once we have calculated the maximum messiness possible
             * we check if the minimum messiness of the words before
             * allow us to have all the words in the string
             */
            for(int j = i-1; j>=0 ; --j){
                numRemainingBlanks -= (words.get(j).length() + 1); //calculate if the previous words + space fit in the blanks
                if(numRemainingBlanks < 0){ //if they don't fit then we'll use the previous
                    break;
                }
                //calculate first previous word's minimum messiness
                int firstJMessiness = j-1 < 0 ? 0 : minimumMessiness[j-1];
                int currentLineMessiness = numRemainingBlanks * numRemainingBlanks;
                //calculate current word's minimumMessiness
                minimumMessiness[i] = Math.min(minimumMessiness[i],
                        firstJMessiness + currentLineMessiness);
            }
        }
        return minimumMessiness[words.size() - 1];
    }
}

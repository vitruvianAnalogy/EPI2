package com.epi.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BedBathAndBeyond {
    public static List<String> decomposeIntoDictionaryWords(Set<String> dictionary, String name){
        int[] lastLength = new int[name.length()];
        Arrays.fill(lastLength,-1);

        for(int i =0; i<name.length(); i++){

    //begin loop
            if(dictionary.contains(name.substring(0,i+1))){
                /**
                 * if substring matches dictionary word, then we know the index/length of the
                 * substring that decomposes well.
                 */
                lastLength[i] = i+1; // size of the "valid" string ending at i
            }


            /**
             * if length hasn't decomposed well, -1 tells us that
             *
             */
            if(lastLength[i] == -1){
                for(int j=0; j<i ; j++){
                    if(lastLength[j]!=-1
                            && dictionary.contains(name.substring(j+1,i+1))){
                        lastLength[i] = i-j; //size of the "valid" string ending at i
                        break;
                    }
                }
            }
    //end loop
        }

        List<String> decompositions = new ArrayList<>();
        if(lastLength[lastLength.length-1] != -1){ // if entire string is valid
            int index = name.length() -1;
            while(index >= 0){
                decompositions.add(name.substring(index + 1 - lastLength[index], index + 1));
            }
        }
        return decompositions;
    }
}

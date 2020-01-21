package com.educative.twopointers;

public class ComparingStringsContainingBackspaces {

    /**
     * Time complexity - O(len1 + len2)
     * @param str1 - A normal string where # means the letter before it gets removed
     * @param str2 - same as above
     * @return
     */
    public static boolean areStringEqual(String str1, String str2){
        int index1 = str1.length()-1;
        int index2 = str2.length()-1;

        while(index1>=0 || index2>=0){ //iterate through both strings
            int i1 = getNextValidCharacterIndex(str1, index1);
            int i2 = getNextValidCharacterIndex(str2, index2);

            if(i1<0 && i2<0) //if both strings have been traversed then strings are equal
                return true;
            if(i1<0 || i2<0) //if one of the strings have been traversed, while other hasn't, then strings are unequal
                return false;
            //if next valid character of both strings is not the same
            //then strings are unequal
            if(str1.charAt(i1)!=str2.charAt(i2))
                return false;
            //if char i1 and i2 are checked we pass the next character in the method
            index1 = i1-1;
            index2 = i2-1;
        }
        return false;
    }

    private static int getNextValidCharacterIndex(String str, int index) {
        int count = 0;
        while(index >= 0){
            if(str.charAt(index)=='#'){
                count++;
            } else if(count > 0){ //if character is valid but backspace are present, we decrease backspace and decrement the index to go to the element after that
                count--;
            } else{
                break;
            }
            index--;
        }
        return index;
    }
}

package com.mithi.algorithms.dynammicp;

import java.util.ArrayList;
import java.util.List;

public class ScreenFitting {

/*
  Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output:
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
 */

    public static int wordsTyping(String[] sentence, int rows, int cols){
        int finalCount   = 0 ;
        List<Integer> array = new ArrayList<>();
        for(int i =0 ; i<sentence.length ; i++){
            array.add(sentence[i] != null ? sentence[i].length() : 0 );
        }
        return finalCount;
    }

    public static void main(String[] args) {

        int count  = wordsTyping(new String[] {"hello" , "world"} ,2,3 );
        System.out.println("count : " + count);
    }
}

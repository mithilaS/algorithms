package com.mithi.algorithms.string;

import java.util.Collections;
import java.util.HashMap;

/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/
public class LongestSubStringWith2Character {

    public static void main(String[] args) {
        lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int leftIndex =0 , rightIndex ;
        System.out.println(s);
        int size =s.length();
        if(size <3) return size;
        int max =2;

        HashMap<Character, Integer> charMaxRight = new HashMap<>();

        for(int i =0; i<size; i++){
            charMaxRight.put(s.charAt(i) , i);
            rightIndex=i;
            if(charMaxRight.size() >2){
             int out =Collections.min(charMaxRight.values());
                charMaxRight.remove(s.charAt(out));
                leftIndex = out +1;

            }
            max = Math.max(max, rightIndex-leftIndex +1);

        }
        System.out.println("max : " + max);
    return max;
    }
}

package com.mithi.algorithms.string;

import java.util.Collections;
import java.util.HashMap;

/*
Longest Substring with At Most K Distinct Characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

Runtime Memory  Language
14 ms	45 MB	java
 */
public class LongestSubStringWithKCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = 0;


        int strLength = s.length();
        if (strLength*k == 0) return len;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();

         len = 1;

        while (right < strLength) {
            // add new character and move right pointer
            characterMap.put(s.charAt(right), right++);
            System.out.println(characterMap);

            // slidewindow contains 3 characters
            if (characterMap.size() == k + 1) {
                // delete the leftmost character
                int del_idx = Collections.min(characterMap.values());
                characterMap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            len = Math.max(len, right - left);
            System.out.println("r : " +  right  +  " l : "  + left + " len : " + len);
        }

        return len;
    }

    public static void main(String[] args) {
        int len = lengthOfLongestSubstringKDistinct("bcbcaabcbcbc" , 2);
        System.out.println(len);
    }
}

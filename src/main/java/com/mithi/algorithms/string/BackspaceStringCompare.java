package com.mithi.algorithms.string;
/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        boolean t = backspaceCompare("ab##ef" ,"c#d#gh");
        System.out.println(t);
    }
    public static boolean backspaceCompare(String S, String T) {
        String sh = getReplacedString(S);
        String th = getReplacedString(T);
        System.out.println("sh: " + sh);
        System.out.println("th: " + th);
        return sh.equals(th);
    }
    private static String getReplacedString(String input) {
        int sub = 0;
        int fi = 0;
        char[]arr = input.toCharArray();
        while(fi < arr.length) {
            if(arr[fi]!='#') {
                arr[sub] = arr[fi];
                System.out.println(arr);

                sub++;
            }else if(sub > 0){
                // reduce the count if # is found
                sub--;
            }
            fi++;
        }
        // This is important . check third parameter
        return new String(arr, 0, sub);
    }

}


package com.mithi.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class StrobogramaticNumber {

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69"));
        System.out.println(isStrobogrammatic("88"));
        System.out.println(isStrobogrammatic("696"));
        System.out.println(isStrobogrammatic("10"));
    }

    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('6', '9');
        characterMap.put('9', '6');
        characterMap.put('0', '0');
        characterMap.put('1', '1');
        characterMap.put('8', '8');

        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!characterMap.containsKey(num.charAt(left))) return false;
            if (characterMap.get(num.charAt(left)) != num.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

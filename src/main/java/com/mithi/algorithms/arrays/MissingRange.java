package com.mithi.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
 */
public class MissingRange {

    public static void main(String[] args) {
        MissingRange mr =new MissingRange();
        List<String> m = mr.findMissingRanges(new int[]{0,1,3,50,75}, 0,99);
        System.out.println(m);


    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : nums) {
            if(i > lower) res.add(lower+((i-1 > lower)?"->"+(i-1):""));
            if(i == upper) return res; // Avoid overflow
            lower = i+1;
        }
        if(lower <= upper) res.add(lower + ((upper > lower)?"->"+(upper):""));
        return res;
    }


}

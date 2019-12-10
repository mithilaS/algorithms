package com.mithi.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumProblem {
    public static void main(String[] args) {
        int target =6 ;
        int[] nums = {3,2,4};
        int[] n  = twoSum(nums, target);
        System.out.println(n[0] + ", " + n[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> intMap = new HashMap<>();
        int[] results = new int[2];

        for(int i =0 ; i<nums.length; intMap.put(nums[i] , i ) ,i++) {
            if(intMap.containsKey(target-nums[i])){
                results[0] =  intMap.get(target-nums[i]);
                results[1] =  i;
                return results;
            }
        }
        return results;
    }
}



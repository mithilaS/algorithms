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
        List<String> m = findMissingRanges(new int[]{-1}, -2,-1);
        System.out.println(m);
    }
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missing = new ArrayList<>();
        /*
        check first no is lower bound or not if not then start range from there only.
        to make range no need to iterate all. Just get the number before the next number in array.
         */
        if(lower-upper==0 && nums.length==0){
            missing.add(String.valueOf(lower));
            return missing;
        }

        if(lower > upper || (lower-upper==0) && nums.length>0){
            return missing;
        }

        if(nums.length==0 && Math.abs(upper-lower) >0){
            missing.add(String.valueOf(lower + "->" +upper));
            return missing;
        }
        for (int i =0;i<nums.length-1;i++) {
            Integer missingRight = null;
            StringBuilder str = new StringBuilder();
            if(i==0 & nums[i]>lower){

              str.append(lower);
              if(Math.abs(nums[i]-lower) >1){
                  str.append("->" ).append(nums[i]-1);
              }
              if(str.toString().length()>0)
                missing.add(str.toString());
            }else{
                int firstNum = nums[i];
                int nextNum = nums[i+1];
                if(Math.abs(nextNum-firstNum) ==2){
                    // this means only one number in between
                    missing.add(String.valueOf(firstNum+1));
                }else if(Math.abs(nextNum-firstNum )>2 && (nextNum <=upper)){
                    str.append(firstNum+1).append("->").append(nextNum-1);
                    missing.add(str.toString());
                }
            }
        }
        int last = nums[nums.length-1];
        if(last < upper){
            if(Math.abs(upper-last) ==1){
                missing.add(String.valueOf(upper));
            }else if(Math.abs(upper-last) >1){
                StringBuilder str = new StringBuilder();
                str.append(last+1).append("->").append(upper);
                missing.add(str.toString());
            }
        }
        System.out.println(missing);
        return missing;
    }
}

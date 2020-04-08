package com.mithi.algorithms.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSumProblem {

    public static void main(String[] args) {
        ThreeSumProblem tsp = new ThreeSumProblem();
        List<List<Integer>> lists = tsp.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ,");
        }
        System.out.println(" ");
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            System.out.println("********************");
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                System.out.println("i : " +  i + " nums[i] : " + num[i] +  " sum : " + sum + " lo: " + lo + " hi: "+ hi);
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        System.out.println("add in array ");
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                            System.out.println("while 2 : lo : " + lo);
                        }
                        while (lo < hi && num[hi] == num[hi-1]) { hi--;
                            System.out.println("while 3: hi : " +  hi);}
                        lo++; hi--;
                        System.out.println("out while :  lo + " + lo + " hi : " + hi);
                    } else if (num[lo] + num[hi] < sum){
                        lo++;
                        System.out.println("in else if  : lo " + lo);
                    }
                    else {
                        hi--;
                        System.out.println("In outside else : " +  hi);
                    }
                }
            }
        }
        return res;
    }
}
/**
 public  List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);
 */

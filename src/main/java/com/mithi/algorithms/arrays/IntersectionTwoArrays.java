package com.mithi.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionTwoArrays {

    public static void main(String[] args) {
       int n1[] =  {1,2,2,1};
       int n2[] = {2,2};
        int n3[] = intersection(n1,n2);
        for(int i =0 ;i<n3.length;i++){
            System.out.println(n3[i]);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

       if(nums1 !=null && nums2 !=null){
            Set<Integer> set1 = new HashSet(Arrays.asList(nums1));
            Set<Integer> set2 = new HashSet(Arrays.asList(nums2));
           boolean set3 =  set1.retainAll(set2);
            int[] results =new int[set1.size()];
            int i =0;
            for (Iterator<Integer> it = set1.iterator(); it.hasNext(); ) {
                results[i] = it.next();
                i++;
            }
            return results;
        }else{
            return new int[]{};
        }


    }
}

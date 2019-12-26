package com.mithi.algorithms.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class NextClosestTime {
    public static void main(String[] args) {
        NextClosestTime closestTime = new NextClosestTime();
        String result  = closestTime.nextClosestTime("19:35");
        System.out.println(result);
    }
    public String nextClosestTime(String time) {
        /*
        HH:MM
        HH MAX IS 23
        MM MAX IS 59
        so first try minutes.. then hour ..if exceeds 23 then add for next with lease value
         */
        //get numbers

        int minuteslast = Integer.valueOf(time.substring(4,5));
        int minutesFirst = Integer.valueOf(time.substring(3,4));
        int hourLast = Integer.valueOf(time.substring(1,2));
        int hourfirst = Integer.valueOf(time.substring(0,1));
        List<Integer> set = new ArrayList<>();
        Integer lastAdded;
        set.add(minutesFirst);
        if(!set.contains(minuteslast)) {
            set.add(minuteslast);
        }
        if(!set.contains(hourfirst))
        set.add(hourfirst);
        if(!set.contains(hourLast))
        set.add(hourLast);
        Collections.sort(set);
        System.out.println(hourfirst + "  " + hourLast +" : "  +  minutesFirst + "  " + minuteslast);
        System.out.println(set);
        //check minute last
        boolean minlast ;
        if(minuteslast<9){
            int i1 = set.indexOf(minuteslast);
            if(i1+1 <set.size()){
                int num  = set.get(i1+1);
                return hourfirst+ "" + hourLast+ ":"+minutesFirst+""+ num;
            }
                minlast = false;
        }
        return null;
    }
}

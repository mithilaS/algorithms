package com.mithi.algorithms.design;

import java.util.HashMap;

public class LoggerRateLimiter {

    private HashMap<String, Integer> msgDict;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        msgDict = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public  boolean shouldPrintMessage(int timestamp, String message) {

        if (!this.msgDict.containsKey(message)) {
            this.msgDict.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {

        LoggerRateLimiter log =  new LoggerRateLimiter();
        boolean shouldPrint = log.shouldPrintMessage(12345 ,"abc");
        System.out.println(shouldPrint);

        shouldPrint  = log.shouldPrintMessage(12356 , "abc");
        System.out.println(shouldPrint);
    }
}

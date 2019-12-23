package com.mithi.algorithms.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    public LRUCache() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1,11);
        map.put(11,2);

        Integer get = map.get(119);
        if(get==null)
            get =-1;
        System.out.println(get);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();

    }
}

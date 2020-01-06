package com.mithi.algorithms.design;

import java.util.ArrayDeque;
import java.util.Deque;
/*
By definition of the moving window, at each step, we add a new element to the window, and at the same time we remove the oldest element from the window. Here, we could apply a data structure called double-ended queue (a.k.a deque) to implement the moving window, which would have the constant time complexity (\mathcal{O}(1)O(1)) to add or remove an element from both its ends.
With the deque, we could reduce the space complexity down to O(N) where N is the size of the moving window.
Secondly, to calculate the sum, we do not need to reiterate the elements in the moving window.

We could keep the sum of the previous moving window, then in order to obtain the sum of the new moving window,
we simply add the new element and deduce the oldest element. With this measure, we then can reduce the time complexity to constant.
 Time complexity O(1)
 */
public class MovingAverageDatastream {

    int size, windowSum = 0, count = 0;
    Deque queue = new ArrayDeque<Integer>();

    public MovingAverageDatastream(int size) {
        this.size = size;
    }

    public double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int)queue.poll() : 0;

        windowSum = windowSum - tail + val;

        return windowSum * 1.0 / Math.min(size, count);
    }

    public static void main(String[] args) {
        MovingAverageDatastream mad = new MovingAverageDatastream(3);
        double next  =mad.next(10);
        System.out.println(next);

        next = mad.next(20);
        System.out.println(next);

        next = mad.next(3);
        System.out.println(next);

        next = mad.next(30);
        System.out.println(next);

        next =mad.next(60);
        System.out.println(next);

    }
}

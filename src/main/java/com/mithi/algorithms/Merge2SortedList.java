package com.mithi.algorithms;

public class Merge2SortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        l1.next = l2 ;
        l2.next = l5;

        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        l3.next = l4 ;
        l4.next = l6;
        ListNode  node = mergeTwoLists(l1,l3);
        System.out.println(node);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
package com.company.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode toLinkedList(int[] input) {
        ListNode head = new ListNode(input[input.length - 1]);
        for (int j = input.length - 2; j >= 0; j--) {
            head = new ListNode(input[j], head);
        }
        return head;
    }

    @Override
    public String toString() {
        ListNode current = this;
        StringBuilder str = new StringBuilder("[").append(current.val);
        while (current.next != null) {
            current = current.next;
            str.append(",");
            str.append(current.val);
        }
        return str.append("]").toString();
    }
}

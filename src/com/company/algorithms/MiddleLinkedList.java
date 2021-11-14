package com.company.algorithms;

import com.company.utils.ListNode;

import java.util.Arrays;

import static com.company.utils.ListNode.toLinkedList;


public class MiddleLinkedList {

    public static void main(String[] args) {
        print(new int[]{1, 2, 3, 4, 5}, "[3,4,5]");
        print(new int[]{1, 2, 3, 4, 5, 6}, "[4,5,6]");
        print(new int[]{1}, "[1]");
        print(new int[]{1, 2}, "[2]");
    }

    private static void print(int[] input, String expected) {
        ListNode head = toLinkedList(input);
        ListNode middle = new MiddleLinkedList().middleNode(head);
        System.out.println("Input " + Arrays.toString(input) + ", output: " + middle + ", expected: " + expected);
    }

    public ListNode middleNode(ListNode head) {
        ListNode current = head, middle = head;
        while (current != null && current.next != null) {
            middle = middle.next;
            current = current.next.next;
        }
        return middle;
    }
}

package com.company.algorithms;

import com.company.utils.ListNode;

import java.util.Arrays;
import java.util.Objects;

import static com.company.utils.ListNode.toLinkedList;


public class RemoveNthNode {

    public static void main(String[] args) {
        print(new int[]{1, 2}, 2, "[2]");
        print(new int[]{1, 2, 3}, 3, "[2,3]");
        print(new int[]{1, 2, 3, 4}, 4, "[2,3,4]");
        print(new int[]{1, 2, 3, 4}, 3, "[1,3,4]");
        print(new int[]{1, 2, 3}, 2, "[1,3]");
        print(new int[]{1, 2, 3, 4}, 2, "[1,2,4]");
        print(new int[]{1, 2, 3, 4, 5}, 2, "[1,2,3,5]");
        print(new int[]{1}, 1, "null");
        print(new int[]{1, 2}, 1, "[1]");
    }

    private static void print(int[] input, int n, String expected) {
        ListNode head = toLinkedList(input);
        ListNode output = new RemoveNthNode().removeNthFromEnd(head, n);
        String str = "Input " + Arrays.toString(input) + ", n: " + n + ", output: " + output + ", expected: " + expected;
        if (Objects.equals(Objects.toString(output), expected)) {
            System.out.println(str);
        } else {
            System.err.println(str);
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;

        int length = 1;
        ListNode current = head, prevToRemove = head;
        while (current != null && current.next != null) {
            if (length > n) {
                prevToRemove = prevToRemove.next;
            }
            if (current.next.next == null) {
                if (length < n) {
                    head = head.next;
                } else {
                    prevToRemove.next = prevToRemove.next.next;
                }
            }
            current = current.next;
            length++;
        }
        return head;
    }
}

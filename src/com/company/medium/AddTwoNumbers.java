package com.company.medium;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
public class AddTwoNumbers {

//    public static void main(String[] args) {
//        ListNode first = of(2, of(4, of(3, null)));
//        ListNode second = of(5, of(6, of(4, null)));
//        ListNode result = new AddTwoNumbers().addTwoNumbers(first, second);
//        System.out.println("RESULT");
//        System.out.print(result.val);
//        while (result.next != null) {
//            result = result.next;
//            System.out.print(result.val);
//        }
//    }

    public static void main(String[] args) {
        ListNode first = of(9, null);
        ListNode second = of(1, of(9, of(9, of(9, of(9, of(9, of(9, of(9, of(9, of(9, null))))))))));
        ListNode result = new AddTwoNumbers().addTwoNumbers(first, second);
        System.out.println("RESULT");
        System.out.print(result.val);
        while (result.next != null) {
            result = result.next;
            System.out.print(result.val);
        }
    }

    private static ListNode of(int val, ListNode next) {
        return new ListNode(val, next);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder("" + l1.val);
        while (l1.next != null) {
            num1.insert(0, l1.next.val);
            l1 = l1.next;
        }

        StringBuilder num2 = new StringBuilder("" + l2.val);
        while (l2.next != null) {
            num2.insert(0, l2.next.val);
            l2 = l2.next;
        }

        BigInteger long1 = new BigInteger(num1.toString());
        BigInteger long2 = new BigInteger(num2.toString());
        BigInteger sum = long1.add(long2);
        String sumStr = sum.toString();
        ListNode result = new ListNode();
        result.val = Character.getNumericValue(sumStr.charAt(0));
        for (int i = 1; i < sumStr.length(); i++) {
            result = new ListNode(Character.getNumericValue(sumStr.charAt(i)), result);
        }
        return result;
    }
}

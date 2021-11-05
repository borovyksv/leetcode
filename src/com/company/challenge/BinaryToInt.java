package com.company.challenge;


import java.util.List;

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

    @Override
    public String toString() {
        String str = String.valueOf(val);
        if (next == null) {
            return str;
        } else {
            str += next.toString();
        }
        return str;
    }
}

class BinaryToInt {
    public int getDecimalValue(ListNode head) {
        int number = head.val;

        while (head.next != null) {
            number = (number << 1) + head.next.val;
            head = head.next;
        }


        return number;
    }

//    private int calc(ListNode node, int deep) {
//        if (node.next == null) {
//            return node.val << deep;
//        }
//        return node.val << deep + calc(node.next, deep - 1);
//    }

    public static void main(String[] args) {

        System.out.println(new BinaryToInt().getDecimalValue(toListNode(List.of(1, 0, 1))));
        System.out.println(new BinaryToInt().getDecimalValue(toListNode(List.of(1, 0, 1, 0))));
        System.out.println(new BinaryToInt().getDecimalValue(toListNode(List.of(0))));
        System.out.println(new BinaryToInt().getDecimalValue(toListNode(List.of(1))));
        System.out.println(new BinaryToInt().getDecimalValue(toListNode(List.of(1,0,0,1,0,0,1,1,1,0,0,0,0,0,0))));
        System.out.println(new BinaryToInt().getDecimalValue(toListNode(List.of(0, 0))));

    }

    private static ListNode toListNode(List<Integer> arr) {
        ListNode listNode = new ListNode(arr.get(arr.size() - 1));
        for (int i = arr.size() - 2; i >= 0; i--) {
            listNode = new ListNode(arr.get(i), listNode);
        }
        return listNode;
    }
}

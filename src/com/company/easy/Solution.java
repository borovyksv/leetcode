package com.company.easy;

//abcabcbb
public class Solution {
    public static void main(String[] args) {
        Node<Integer> zero = new Node<>(0, null);
        Node<Integer> one = new Node<>(1, zero);
        Node<Integer> four = new Node<>(4, one);
        Node<Integer> five = new Node<>(5, four);
        LinkedList<Integer> list = new LinkedList<>(five);
        list.print();
        list.reverse();
        System.out.println();
        list.print();
        System.out.println();

    }


}

class Node<T> {
    T element;
    Node<T> next;

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                '}';
    }
}

class LinkedList<T> {
    Node<T> head;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

      public void print() {
          Node<T> current = this.head;
          System.out.print(current.element);
          while (current.next != null) {
              current = current.next;
              System.out.print(current.element);
          }
      }


    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}
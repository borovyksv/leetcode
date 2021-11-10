package com.company.algorithms;

import java.util.Arrays;

//Write a function that reverses a string. The input string is given as an array of characters s.
public class ReverseString {
    public static void main(String[] args) {
        print(new char[]{'h', 'e', 'l', 'l', 'o'}, "[o,l,l,e,h]");
        print(new char[]{'h', 'i'}, "[i,h]");
        print(new char[]{'h'}, "[h]");
        print(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, "[h,a,n,n,a,H]");
    }

    private static void print(char[] chars, String s) {
        System.out.print("input: " + Arrays.toString(chars));
        new ReverseString().reverseString(chars);
        System.out.println(", output: " + Arrays.toString(chars) + ", expected: " + s);
    }

    public void reverseString(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
    }
}

package com.company.algorithms;

//Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
public class ReverseWordsInStringIII {

    public static void main(String[] args) {
        print("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc");
        print("God Ding", "doG gniD");
    }

    private static void print(String input, String expected) {
        System.out.println("input: " + input +
                ", output: " + new ReverseWordsInStringIII().reverseWords(input) +
                ", expected: " + expected);
    }

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String chars : split) {
            char[] charArray = chars.toCharArray();
            reverseString(charArray);
            sb.append(charArray);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public void reverseString(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
    }
}

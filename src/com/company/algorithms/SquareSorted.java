package com.company.algorithms;

import java.util.Arrays;

public class SquareSorted {

    public static void main(String[] args) {
        System.out.println("expected: [0,1,9,16,100], actual: " + Arrays.toString(new SquareSorted().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int resEndIndex = nums.length - 1;

        while (start <= end) {
            int startElement = nums[start] * nums[start];
            int endElement = nums[end] * nums[end];

            if (startElement > endElement) {
                result[resEndIndex--] = startElement;
                start++;
            } else {
                result[resEndIndex--] = endElement;
                end--;
            }
        }

        return result;
    }
}

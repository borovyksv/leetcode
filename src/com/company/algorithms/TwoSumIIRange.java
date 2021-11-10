package com.company.algorithms;

import java.util.Arrays;

public class TwoSumIIRange {

    public static void main(String[] args) {
        print(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2});
        print(new int[]{1, 2, 3, 4, 5, 10}, 9, new int[]{1, 2});
        print(new int[]{2, 3, 4}, 6, new int[]{1, 3});
        print(new int[]{-1, 0}, -1, new int[]{1, 2});
        print(new int[]{-999, 0, 2, 3, 4, 5, 6, 1000}, 1, new int[]{1, 8});
        print(new int[]{1,2,3,4,4,9,56,90},8, new int[]{4, 5});
    }

    private static void print(int[] input, int target, int[] output) {
        System.out.printf("numbers = %s, target = %d, actual = %s, expected = %s%n",
                Arrays.toString(input), target, Arrays.toString(new TwoSumIIRange().twoSum(input, target)), Arrays.toString(output));
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int hi = numbers.length - 1;
        while (numbers[low] + numbers[hi] != target) {
            if (numbers[low] + numbers[hi] < target) {
                low++;
            } else {
                hi--;
            }
        }
        return new int[]{low + 1, hi + 1};
    }
}

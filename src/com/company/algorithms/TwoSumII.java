package com.company.algorithms;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        print(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2});
        print(new int[]{2, 3, 4}, 6, new int[]{1, 3});
        print(new int[]{-1, 0}, -1, new int[]{1, 2});
        print(new int[]{-999, 0, 2, 3, 4, 5, 6, 1000}, 1, new int[]{1, 8});
        print(new int[]{1,2,3,4,4,9,56,90},8, new int[]{4, 5});
    }

    private static void print(int[] input, int target, int[] output) {
        System.out.printf("numbers = %s, target = %d, actual = %s, expected = %s%n",
                Arrays.toString(input), target, Arrays.toString(new TwoSumII().twoSum(input, target)), Arrays.toString(output));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int targetAddend = target - numbers[i];
            int foundAddendIndex = search(numbers, targetAddend, i + 1);
            if (foundAddendIndex != -1) {
                return new int[]{i+1, foundAddendIndex+1};
            }
        }
        return null;
    }

    public int search(int[] nums, int target, int initLow) {
        int low = initLow;
        int hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

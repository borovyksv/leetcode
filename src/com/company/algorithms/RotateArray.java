package com.company.algorithms;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        print(new int[]{1, 2, 3, 4, 5, 6, 7}, 1, "[7,1,2,3,4,5,6]");
        print(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, "[6,7,1,2,3,4,5]");
        print(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, "[5,6,7,1,2,3,4]");
        print(new int[]{-1}, 2, "[-1]");
        print(new int[]{1, 2}, 3, "[2,1]");
        print(new int[]{1, 2}, 2, "[1,2]");
        print(new int[]{1, 2}, 5, "[1,2]");
        print(new int[]{1, 2, 3}, 4, "[3,1,2]");
    }

    private static void print(int[] nums, int steps, String expected) {
        new RotateArray().rotate(nums, steps);
        System.out.println(Arrays.toString(nums) + ", expected: " + expected);
    }

    public void rotate(int[] nums, int k) {
        if (k > nums.length) k = k % nums.length;
        int[] arr1 = new int[k];
        int[] arr2 = new int[nums.length - k];
        System.arraycopy(nums, nums.length - k, arr1, 0, k);
        System.arraycopy(nums, 0, arr2, 0, nums.length - k);

        System.arraycopy(arr1, 0, nums, 0, arr1.length);
        System.arraycopy(arr2, 0, nums, arr1.length, arr2.length);
    }
}

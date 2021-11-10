package com.company.algorithms;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        print(new int[]{0, 1, 0, 3, 12}, "[1,3,12,0,0]");
        print(new int[]{0, 0, 0, 3, 12}, "[3,12,0,0,0]");
        print(new int[]{0, 0, 0, 0, 0}, "[0,0,0,0,0]");
        print(new int[]{1, 3, 12, 0, 0}, "[1,3,12,0,0]");
        print(new int[]{1, 1, 1, 1, 1}, "[1,1,1,1,1]");
        print(new int[]{0}, "[0]");
//        print(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 1}, "[1...,0,0,0,0,0]");

    }

    private static void print(int[] nums, String expected) {
        System.out.print("input: " + Arrays.toString(nums) + ", actual: ");
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums) + ", expected: " + expected);
    }

    public void moveZeroes(int[] nums) {
        int insertPosition = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPosition++] = num;
            }
        }

        while (insertPosition < nums.length) {
            nums[insertPosition++] = 0;
        }
    }
}

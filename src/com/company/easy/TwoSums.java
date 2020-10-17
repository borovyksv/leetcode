package com.company.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * You can return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     */

    public static void main(String[] args) {
        test(new int[]{2, 7, 11, 15}, 9);
        test(new int[]{3, 2, 4}, 6);
        test(new int[]{3, 3}, 6);
        test(new int[]{0, 4, 3, 0}, 0);
        test(new int[]{-3, 4, 3, 90}, 0);
    }

    private static void test(int[] nums, int target) {
        System.out.println(Arrays.toString(new TwoSums().twoSum(nums, target)));
        System.out.println(Arrays.toString(new TwoSums().twoSumOptimal(nums, target)));
        System.out.println("-------------------------------");
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

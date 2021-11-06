package com.company.algorithms;

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition p = new SearchInsertPosition();
        print(p, 5, 2, new int[]{1, 3, 5, 6});
        print(p, 2, 1, new int[]{1, 3, 5, 6});
        print(p, 7, 4, new int[]{1, 3, 5, 6});
        print(p, 0, 0, new int[]{1, 3, 5, 6});
        print(p, 0, 0, new int[]{1});
        print(p, 1, 0, new int[]{1});
        print(p, 0, 0, new int[]{1,3});
        print(p, 8, 3, new int[]{3,5,7,9,10});

    }

    private static void print(SearchInsertPosition p, int target, int expected, int[] nums) {
        System.out.println("target: " + target + ", expected: " + expected + ", actual: " + p.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int hi = nums.length;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

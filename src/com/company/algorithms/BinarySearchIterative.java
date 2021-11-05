package com.company.algorithms;

public class BinarySearchIterative {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(new BinarySearchIterative().search(nums, -10) + " expect: -1");
        System.out.println(new BinarySearchIterative().search(nums, -1) + " expect: 0");
        System.out.println(new BinarySearchIterative().search(nums, 0) + " expect: 1");
        System.out.println(new BinarySearchIterative().search(nums, 3) + " expect: 2");
        System.out.println(new BinarySearchIterative().search(nums, 5) + " expect: 3");
        System.out.println(new BinarySearchIterative().search(nums, 9) + " expect: 4");
        System.out.println(new BinarySearchIterative().search(nums, 12) + " expect: 5");
    }

    public int search(int[] nums, int target) {
        int low = 0;
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

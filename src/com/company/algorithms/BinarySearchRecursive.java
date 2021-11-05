package com.company.algorithms;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(new BinarySearchRecursive().search(nums, -10) + " expect: -1");
        System.out.println(new BinarySearchRecursive().search(nums, -1) + " expect: 0");
        System.out.println(new BinarySearchRecursive().search(nums, 0) + " expect: 1");
        System.out.println(new BinarySearchRecursive().search(nums, 3) + " expect: 2");
        System.out.println(new BinarySearchRecursive().search(nums, 5) + " expect: 3");
        System.out.println(new BinarySearchRecursive().search(nums, 9) + " expect: 4");
        System.out.println(new BinarySearchRecursive().search(nums, 12) + " expect: 5");
//        System.out.println(new BinarySearch().bisearch(new int[]{1}, 0, 0, 0, 1));
    }

    public int search(int[] nums, int target) {
        return bisearch(nums, target, 0, nums.length - 1);
    }

    public int bisearch(int[] nums, int target, int low, int hi) {
        if (low > hi) {
            return -1;
        }
        int mid = low + (hi - low)/2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return bisearch(nums, target, low, mid - 1);
        }
        return bisearch(nums, target, mid + 1, hi);
    }


}

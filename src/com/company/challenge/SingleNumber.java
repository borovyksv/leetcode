package com.company.challenge;

import java.util.*;

class SingleNumber {
    public static void main(String[] args) {
        var nums = new int[]{4, 1, 2, 1, 2};
        System.out.println("Single: " + new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> singleValues = new HashSet<>();
        for (int num : nums) {
            if (!singleValues.remove(num)) {
                singleValues.add(num);
            }
        }
        return singleValues.iterator().next();
    }
}

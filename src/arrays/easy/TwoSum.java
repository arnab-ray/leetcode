package arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToComplimentMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(numToComplimentMap.containsKey(complement)) {
                return new int[] {numToComplimentMap.get(complement), i};
            }
            numToComplimentMap.put(nums[i], i);
        }

        return new int[] {};
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] indices = twoSum(nums, 9);
        System.out.println(indices[0] + "," + indices[1]);
    }
}
// This problem was asked by Uber.

// Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

// Follow-up: what if you can't use division?

package codingproblems.dailycodingproblem;

import java.util.*;

public class Day2_ProductOfAllNumbersExceptSelf {
    private static int[] productOfAllNumbersExceptSelf(int[] nums) {
        // Time complexity - O(n), Space complexity - O(1)
        int[] res = new int[nums.length];
        int currentLeftProduct = 1;

        for(int i = 0; i < res.length; i++) {
            res[i] = currentLeftProduct;
            currentLeftProduct *= nums[i];
        }

        int currentRightProduct = 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= currentRightProduct;
            currentRightProduct *= nums[i]; 
        }

        return res;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(productOfAllNumbersExceptSelf(new int[] { 1, 2, 3, 4, 5 }))); // Should return [120, 60, 40, 30, 24]
        System.out.println(Arrays.toString(productOfAllNumbersExceptSelf(new int[] { 3, 2, 1 }))); // Should return [2, 3, 6]
    }
}

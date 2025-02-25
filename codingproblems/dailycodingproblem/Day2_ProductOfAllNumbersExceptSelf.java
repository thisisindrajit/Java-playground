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

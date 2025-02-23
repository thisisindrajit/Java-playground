// This problem was recently asked by Google.

// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

// Bonus: Can you do this in one pass?
package codingproblems.dailycodingproblem;

import java.util.*;

public class Day1_TwoSum {
    private static boolean twoSum(int[] nums, int target) {
        // Time complexity - O(n), Space complexity - O(n)
        HashSet<Integer> diffSet = new HashSet<>();

        // One pass solution
        for(int n: nums) {
            // Calculating the difference between the current number and target
            int diff = target - n;

            // Checking if the difference is available in the hashset. If yes, then a pair is found
            if(diffSet.contains(diff)) {
                return true;
            }

            // Adding the current number to the hashset
            diffSet.add(n);
        }

        return false;
    }

    public static void main(String args[]) {
        System.out.println(twoSum(new int[] { 10, 15, 3, 7 }, 17)); // Should return true
        System.out.println(twoSum(new int[] { 10, 15, 3, 7, 8 }, 19)); // Should return false
        System.out.println(twoSum(new int[] { -3, 4, 3, 90 }, 0)); // Should return true
    }
}

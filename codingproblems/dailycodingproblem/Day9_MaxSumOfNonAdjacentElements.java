// This problem was asked by Airbnb.

// Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

// For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

// Follow-up: Can you do this in O(N) time and constant space?

package codingproblems.dailycodingproblem;

import java.util.*;

public class Day9_MaxSumOfNonAdjacentElements {
    private static int maxSumOfNonAdjacentElements(int[] nums) {
        // Time complexity - , Space complexity - 
        int res = 0;

        return res;
    } 

    public static void main(String[] args) {
        System.out.println(maxSumOfNonAdjacentElements(new int[]{ 2, 4, 6, 2, 5 })); // Should return 13
        System.out.println(maxSumOfNonAdjacentElements(new int[]{ 5, 1, 1, 5 })); // Should return 10
    }
}

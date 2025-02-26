// This problem was asked by Airbnb.

// Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

// For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

// Follow-up: Can you do this in O(N) time and constant space?

package codingproblems.dailycodingproblem;

public class Day9_MaxSumOfNonAdjacentElements {
    private static int maxSumOfNonAdjacentElements(int[] nums) {
        // Time complexity - O(n), Space complexity - O(1)
        if (nums.length == 1)
            return nums[0];

        int[] lastTwoMax = new int[2];
        lastTwoMax[0] = nums[0];
        lastTwoMax[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int curMax = Math.max(nums[i], Math.max(nums[i] + lastTwoMax[0], lastTwoMax[1]));

            lastTwoMax[0] = lastTwoMax[1];
            lastTwoMax[1] = curMax;
        }

        return lastTwoMax[1];
    }

    public static void main(String[] args) {
        System.out.println(maxSumOfNonAdjacentElements(new int[] { 2 })); // Should return 2
        System.out.println(maxSumOfNonAdjacentElements(new int[] { -2, 4 })); // Should return 4
        System.out.println(maxSumOfNonAdjacentElements(new int[] { 2, 4, 6, 2, 5 })); // Should return 13
        System.out.println(maxSumOfNonAdjacentElements(new int[] { 5, 1, 1, 5 })); // Should return 10
        System.out.println(maxSumOfNonAdjacentElements(new int[] { 5, 20, 15, -2, 18 })); // Should return 38
        System.out.println(maxSumOfNonAdjacentElements(new int[] { 4, 1, 6, 3, 2 })); // Should return 12
        System.out.println(maxSumOfNonAdjacentElements(new int[] { -5, -2, -3, -20, -7, -8, -9 })); // Should return -2
        System.out.println(maxSumOfNonAdjacentElements(new int[] { -2, -5, 6, -2, -3 })); // Should return 6
    }
}

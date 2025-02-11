// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

package codingproblems;

import java.util.Arrays;

public class MinimumDifferenceAfterThreeMoves {
    // [1,5,0,4,10,14]
    // sorted - [0,1,4,5,10,14]

    // We can see a sliding window pattern here
    // [0,1,4,X,X,X]
    // [X,1,4,5,X,X]
    // [X,X,4,5,10,X]
    // [X,X,X,5,10,14]
    private static int minDifference(int[] nums) {
        if(nums.length <= 4) {
            return 0;
        }

        // Sorting takes O(nlogn) time
        Arrays.sort(nums);
        
        int res = Integer.MAX_VALUE, l = 0, r = nums.length - 4;

        while(r < nums.length) {
            res = Math.min(res, nums[r] - nums[l]);
            r++;
            l++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{ 1, 5, 0, 4, 10, 14 })); // Should return 4
        System.out.println(minDifference(new int[]{ 6, 6, 0, 1, 1, 4, 6 })); // Should return 2
    }
}

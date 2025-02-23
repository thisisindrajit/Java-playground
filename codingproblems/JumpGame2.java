// https://leetcode.com/problems/jump-game-ii

package codingproblems;

public class JumpGame2 {
    private static int minimumNumberOfJumps(int[] nums) {
        int minNoOfSteps = 0, left = 0, right = 0;

        while(right < nums.length - 1) {
            int farthest = 0;
            int i = left;

            while(i <= right) {
                farthest = Math.max(farthest, i + nums[i]);
                i++;
            }

            left = right + 1;
            right = farthest;
            minNoOfSteps++;
        }

        return minNoOfSteps;
	}

	public static void main(String args[]) {
		System.out.println(minimumNumberOfJumps(new int[]{ 2, 3, 1, 1, 4 })); // Should return 2
		System.out.println(minimumNumberOfJumps(new int[]{ 2, 1, 2, 3, 1, 1, 1, 4 })); // Should return 4
	}
}

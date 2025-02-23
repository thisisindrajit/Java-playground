// https://leetcode.com/problems/jump-game

package codingproblems;

public class JumpGame {
    private static boolean canJump(int[] nums) {
        // Optimal solution is greedy approach. Start from the end and move the goal if you are able to attain the current goal (which is the last index at the start)
        int curGoalIndex = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            // If we are able to reach current goal from the ith position, then we change the current goal to ith position because we are certain that if we reach the ith position, we can reach the current goal also.
            if(i + nums[i] >= curGoalIndex) {
                curGoalIndex = i;
            }
        }

        return curGoalIndex == 0 ? true : false;
	}

	public static void main(String args[]) {
		System.out.println(canJump(new int[]{ 2, 3, 1, 1, 4 })); // Should return true
		System.out.println(canJump(new int[]{ 3, 2, 1, 0, 4 })); // Should return false
	}
}

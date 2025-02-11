package codingproblems;

import java.util.Arrays;

class Solution {
    // [1,5,0,4,10,14]
    // sorted - [0,1,4,5,10,14]

    // We can see a sliding window pattern here
    // [0,1,4,X,X,X]
    // [X,1,4,5,X,X]
    // [X,X,4,5,10,X]
    // [X,X,X,5,10,14]
    public int minDifference(int[] nums) {
        if(nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        
        int res = Integer.MAX_VALUE, l = 0, r = nums.length - 4;

        while(r < nums.length) {
            res = Math.min(res, nums[r] - nums[l]);
            r++;
            l++;
        }

        return res;
    }
}

public class MinimumDifferenceAfterThreeMoves {
    
}

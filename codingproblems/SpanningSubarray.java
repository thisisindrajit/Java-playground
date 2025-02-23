// QUESTION ASKED BY GOOGLE - https://leetcode.com/discuss/interview-question/1312570/google-tps-may-2021

package codingproblems;

import java.util.*;

public class SpanningSubarray {
    private static int lengthOfSpanningSubarray(int[] nums) {
        int res = Integer.MAX_VALUE;
        Set<Integer> uniqueNumSet = new HashSet<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            uniqueNumSet.add(n);
        }

        int l = 0, r = 0;

        while (r < nums.length) {
            // Add the current number to hashmap
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);

            // If the current window contains all unique elements
            while (l <= r && count.size() == uniqueNumSet.size()) {
                res = Math.min(res, r - l + 1);
                count.put(nums[l], count.get(nums[l]) - 1);
                count.remove(nums[l], 0);
                l++;
            }

            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfSpanningSubarray(new int[]{ 1, 2, 3, 3, 2, 4, 1, 2, 2 })); // Should return 4
    }
}

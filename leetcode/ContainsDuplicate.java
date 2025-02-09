package leetcode;

import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create a HashSet to store the unique numbers. A set doesn't allow duplicates.
        HashSet<Integer> numSet = new HashSet<>();

        // Iterate through the array and check if the number is already present in the set.
        // If it is present, return true. Else, add the number to the set.
        for (int i : nums) {
            if (numSet.contains(i)) {
                return true;
            }

            numSet.add(i);
        }

        return false;
    }
}

public class ContainsDuplicate {
    public static void main(String args[]) {
        Solution s = new Solution();

        System.out.println(s.hasDuplicate(new int[]{1, 2, 3, 1})); // This must return true
        System.out.println(s.hasDuplicate(new int[]{1, 2, 3, 4})); // This must return false
    }
}

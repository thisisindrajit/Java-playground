// https://leetcode.com/problems/contains-duplicate/ 

package codingproblems;

import java.util.HashSet;

public class ContainsDuplicate {
    private static boolean hasDuplicate(int[] nums) {
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

    public static void main(String args[]) {
        System.out.println(hasDuplicate(new int[]{ 1, 2, 3, 1 })); // Should return true
        System.out.println(hasDuplicate(new int[]{ 1, 2, 3, 4 })); // Should return false
    }
}

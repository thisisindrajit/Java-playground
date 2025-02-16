// QUESTION ASKED IN MICROSOFT INTERNAL SHIFT INTERVIEW - https://leetcode.com/problems/three-equal-parts/

package codingproblems;

public class ThreeEqualParts {
    private static int[] findThreeEqualParts(int[] arr) {
        int[] res = new int[2];

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findThreeEqualParts(new int[]{ 1, 0, 1, 0, 1 })); // Should return [0,3]
        System.out.println(findThreeEqualParts(new int[]{ 1, 1, 0, 1, 1 })); // Should return [-1,-1]
        System.out.println(findThreeEqualParts(new int[]{ 1, 1, 0, 0, 1 })); // Should return [0,2]
    }
}
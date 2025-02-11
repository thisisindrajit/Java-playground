// https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/

// Given an array of integers, find the nearest smaller number for every element such that the smaller element is on the left side.

// Examples:
// Input:  arr[] = {1, 6, 4, 10, 2, 5}
// Output:         {_, 1, 1,  4, 1, 2}
// First element (‘1’) has no element on left side. For 6, there is only one smaller element on left side ‘1’.  For 10, there are three smaller elements on left side (1, 6 and 4), nearest among the three elements is 4.

// Input: arr[] = {1, 3, 0, 2, 5}
// Output:        {_, 1, _, 0, 2}

package codingproblems;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerNumber {
    private static int[] findNearestSmallerNumbers(int[] nums) {
        int[] res = new int[nums.length];
        // Create a stack to store the numbers in an increasing order (Monotonic stack)
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            // Pop from the stack until the current number becomes greater than the value at
            // the top of the stack
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }

            // If the stack becomes empty, set -1. Else get the value from the top of the
            // stack
            res[i] = st.isEmpty() ? -1 : st.peek();

            // Push the current value to the stack
            st.push(nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNearestSmallerNumbers(new int[] { 1, 6, 4, 10, 2, 5 }))); // Should
                                                                                                         // return [-1,
                                                                                                         // 1, 1, 4, 1,
                                                                                                         // 2]
        System.out.println(Arrays.toString(findNearestSmallerNumbers(new int[] { 1, 3, 0, 2, 5 }))); // Should return
                                                                                                     // [-1, 1, -1, 0,
                                                                                                     // 2]
        System.out.println(Arrays.toString(findNearestSmallerNumbers(new int[] { 2, 1, 3, 2, 1, 3 }))); // Should return
                                                                                                        // [-1, -1, 1,
                                                                                                        // 1, -1, 1]
    }
}

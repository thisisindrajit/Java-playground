// This problem was asked by Stripe.

// Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

// You can modify the input array in-place.

package codingproblems.dailycodingproblem;

public class Day4_FirstMissingPositive {
    private static int firstMissingPositive(int[] nums) {
        // Time complexity - O(n), Space complexity - O(1)
        int res = -1;

        // Cyclic sort (Modifying the array in place)
        for(int i = 0; i < nums.length;) {
            // Four conditions to check: If the number is positive, if the expected index of number lies with range and if the number is at the expected index, and the  number doesn't exist in the expected index already (For edge cases like [1,1], we need to check the 4th condition otherwise it will result in an infinite loop)
            if(nums[i] > 0 && nums[i] - 1 < nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        // Getting the first missing positive
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res = i + 1;
                break;
            }
        }

        return res == -1 ? nums.length + 1 : res;
    } 

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{ 3, 4, -1, 1 })); // Should return 2
        System.out.println(firstMissingPositive(new int[]{ 1, 2, 0 })); // Should return 3
        System.out.println(firstMissingPositive(new int[]{ 1, 1 })); // Should return 2
    }    
}

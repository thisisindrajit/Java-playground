// QUESTION ASKED BY GOOGLE - https://leetcode.com/discuss/interview-question/algorithms/125078/find-leftmost-smaller-number-in-an-array

// CHATGPT ANSWER EXPLANATION - https://chatgpt.com/share/67a9aa3e-752c-8012-906d-f49fe5fac6a9

// Find leftmost smaller number in an array

// input - [4, 1, 3, 2, 1, 3, 2]
// index - [0, 1, 2, 3, 4, 5, 6]
// ans -   [-1, -1, 1, 1, -1, 1, 1]
// m - 4

// Constraint: 1 <= input[i] <= m

// ----------

// Algorithm:
// 1. Initialize aux_arr of size m + 1 with max as default value

// 2. finding minimum index of input[i] (aux_arr[i] = min(aux_arr[i], i)
// aux_arr = [max, 1, 3, 2, 0]

// 3. Propagate the minimum indexes (aux_arr[i] = min(aux_arr[i], aux_arr[i - 1])
// But why?
// We update arr[x] = min(arr[x], arr[x-1]), ensuring that:
//     - arr[x] stores the smallest index among all numbers {1, 2, ..., x}.

// aux_arr = [max, 1, 1, 1, 0]
 
// 4. if aux_arr[input[i] - 1] > i return -1, else return input[aux_arr[input[i] - 1]]
// res = [-1, -1, 1, 1, -1, 1, 1]

// Another example:
// input - [2, 3, 4, 1, 5]
// ans -   [-1, 2, 2, -1, 2]

// Steps:
// 1. aux_arr = [max, 3, 0, 1, 2, 4]
// 2. aux_arr = [max, 3, 0, 0, 0, 0]
// 3. res = [-1, 2, 2, -1, 2]

package codingproblems;

import java.util.Arrays;

public class LeftmostSmallerNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.findLeftmostSmallerNumber(new int[]{ 2, 1, 3, 2, 1, 3 }, 3))); // Should return [-1, -1, 2, 1, -1, 2]
    }
}

class Solution {
    public int[] findLeftmostSmallerNumber(int[] nums, int m) {
        int[] res = new int[nums.length];
        int[] aux_arr = new int[m + 1];
        Arrays.fill(aux_arr, Integer.MAX_VALUE);

        // populate aux_arr with minimum index of each number
        for(int i = 0; i < nums.length; i++) {
            aux_arr[nums[i]] = Math.min(aux_arr[nums[i]], i);
        }

        // propagate minimum indexes such that arr[x] stores the smallest index among all numbers {1, 2, ..., x}
        for(int i = 1; i < aux_arr.length; i++) {
            aux_arr[i] = Math.min(aux_arr[i], aux_arr[i - 1]);
        }

        // Populate res
        for(int i = 0; i < nums.length; i++) {
            if(aux_arr[nums[i] - 1] >= i) {
                res[i] = -1;
            } else {
                res[i] = nums[aux_arr[nums[i] - 1]];
            }
        }

        return res;
    }
}
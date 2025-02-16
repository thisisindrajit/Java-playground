// QUESTION ASKED BY GOOGLE - https://leetcode.com/discuss/interview-question/algorithms/4749105/Google-or-Phone-Screening-or-Remove-common-elements-from-array-from-prefix-of-length-K-in-two-arrays/

package codingproblems;

import java.util.*;

public class RemoveCommonElementsPrefixLengthK {
    private static List<Integer> removeCommonElements(int[] arr1, int[] arr2, int k) {
        List<Integer> res = new ArrayList<Integer>(); 
        Set<Integer> prefixSet = new HashSet<Integer>();
        int uncommonElementCount = 0;

        // Adding first k elements of arr1 to set
        for(int i = 0; i < k; i++) {
            prefixSet.add(arr1[i]);
        }

        // Traversing through arr2 and finding out the first k uncommon elements, inserting them in res and then filling res with rest of arr2
        for(int i = 0; i < arr2.length; i++) {
            if(prefixSet.contains(arr2[i]) && uncommonElementCount < k) {
                continue;
            }

            res.add(arr2[i]);
            uncommonElementCount++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 4, 8, 2, 6, 5, 3, 10, 2, 1 };
        int k = 4;

        List<Integer> result = removeCommonElements(arr1, arr2, k);

        System.out.println(result.toString()); // Should return [8, 6, 5, 10, 2, 1]
    }
}

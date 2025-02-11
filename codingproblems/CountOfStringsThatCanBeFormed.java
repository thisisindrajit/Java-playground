// QUESTION ASKED BY GOOGLE - https://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/

// Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at most one 'b' and two 'c's allowed.

// Examples : 

// Input : n = 3 
// Output : 19 
// Below strings follow given constraints:
// aaa aab aac aba abc aca acb acc baa
// bac bca bcc caa cab cac cba cbc cca ccb 

// Input  : n = 4
// Output : 39

package codingproblems;

public class CountOfStringsThatCanBeFormed {
    private static int findCountOfStringsThatCanBeFormed(int n) {
        int res = 0;

        // Approaches that can be used:
        // Backtracking (Brute force) [This can be found in geeksforgeeks link]
        // Dynamic Programming (Optimization) [This can be found in geeksforgeeks link]
        // Combinatorics (BEST APPROACH - O(1)) [https://claude.ai/chat/d3045001-38a5-4518-ba81-ae6238c281d2]

        // Combinatorics approach (Taking example of n = 3)
        // Case 1 - Only a's are used (aaa)
        res += 1;

        // Case 2 - No b, 2 c's are used (acc, cca, cac)
        // We need to choose 2 positions for c's from n positions, others will be filled with a's (nC2 = n! / (n - 2)! * 2!)
        res += (n * (n - 1)) / 2;

        // Case 3 - No b, only 1 c is used (aca, aac, caa)
        // We need to choose 1 position for c from n positions, others will be filled with a's (nC1 = n! / (n - 1)! * 1!)
        res += n;

        // Case 4 - No c, only 1 b is used (aba, aab, baa)
        // We need to choose 1 position for b from n positions, others will be filled with a's (nC1 = n! / (n - 1)! * 1!)
        res += n;

        // Case 5 - One b and one c is used (abc, bac, bca, acb, cab, cba)
        // We need to choose 1 position for b and 1 position for c from n positions, others will be filled with a's (nC2 = n! / (n - 2)! * 2!) and then 2 ways to arrange b and c
        res += n * (n - 1);

        // Case 6 - One b and two c's are used (bcb, ccb, bcc)
        // We need to choose 2 positions for c and 1 position for b from n positions, others will be filled with a's (nC3 = n! / (n - 3)! * 3!) and then 3 ways to arrange b and c
        res += (n * (n - 1) * (n - 2)) / 2;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findCountOfStringsThatCanBeFormed(3)); // Should return 19
        System.out.println(findCountOfStringsThatCanBeFormed(4)); // Should return 39
    }
}


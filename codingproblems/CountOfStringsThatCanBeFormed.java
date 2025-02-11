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
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findCountOfStringsThatCanBeFormed(3)); // Should return 19
        System.out.println(sol.findCountOfStringsThatCanBeFormed(4)); // Should return 39
    }
}

class Solution {
    public int findCountOfStringsThatCanBeFormed(int n) {
        int res = 0;


        return res;
    }
}

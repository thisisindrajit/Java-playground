// Question link - https://cses.fi/problemset/task/1070

// Example - 4
// 1 2 3 4
// 2 4 1 3 maybe some other solution (See the pattern here - Even numbers and odd numbers are grouped together as difference between two even numbers and two odd numbers is always greater than 1)

// Example - 5
// 1 2 3 4 5
// 2 4 1 3 5 or 4 2 5 3 1 or maybe some other solution (See the pattern here - Even numbers and odd numbers are grouped together as difference between two even numbers and two odd numbers is always greater than 1)

// Example - 6
// 1 2 3 4 5 6
// 2 4 6 1 3 5 or 4 6 2 5 3 1 or maybe some other solution (See the pattern here - Even numbers and odd numbers are grouped together as difference between two even numbers and two odd numbers is always greater than 1)

// SUCH A DUMMY SOLUTION FOR WHICH I THOUGHT IN TERMS OF RECURSION :(
// Solution link - https://www.geeksforgeeks.org/cses-solutions-permutations/

package cses;
    
import java.util.Scanner;

public class STARPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Why use StringBuilder instead of just appending String in lines 32 and 38?
        
        // Strings in Java are immutable. This means that methods that operate on strings cannot ever change the value of a string. String concatenation using += works by allocating memory for an entirely new string that is the concatenation of the two previous ones, and replacing the reference with this new string. Each new concatenation requires the construction of an entirely new String object.

        // In contrast, the StringBuilder and StringBuffer classes are implemented as a mutable sequence of characters. This means that as you append new Strings or characters onto a StringBuilder, it simply updates its internal array to reflect the changes you've made. This means that new memory is only allocated when the string grows past the buffer already existing in a StringBuilder.

        StringBuilder sb = new StringBuilder();

        if (n == 2 || n == 3) {
            System.out.print("NO SOLUTION");
        } else {
            // First print all even numbers
            for (long i = 2; i <= n; i += 2) {
                sb.append(i);
                sb.append(' ');
            }

            // Then print all odd numbers
            for (long i = 1; i <= n; i += 2) {
                sb.append(i);
                sb.append(' ');
            }

            System.out.print(sb.toString());
        }

        sc.close();
    }
}

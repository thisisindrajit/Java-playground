// Question link - https://cses.fi/problemset/task/1083

// Example - 6
// Sum of elements from 1 to 6 is 6(6 + 1)/2 = 21 (1 + 2 + 3 + 4 + 5 + 6)

package cses;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong(), totalSum = (n * (n + 1)) / 2, listSum = 0;

        for (int i = 0; i < n - 1; i++) {
            int curNum = scanner.nextInt();

            listSum += curNum;
        }

        System.out.println(totalSum - listSum);

        scanner.close();
    }
}
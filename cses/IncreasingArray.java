// Question link - https://cses.fi/problemset/task/1094

package cses;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long minimumMoves = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println("0");
        } else {
            for (int i = 1; i < n; i++) {
                // If it's already greater, we need not worry
                if (arr[i] > arr[i - 1]) {
                    continue;
                }

                // Else the difference between the previous element and current element is going to be
                // the minimum number of moves
                minimumMoves += (arr[i - 1] - arr[i]);

                // Also make sure to modify the current element to be equal to it's previous element
                arr[i] = arr[i - 1];
            }

            System.out.println(minimumMoves);
        }

        sc.close();
    }
}

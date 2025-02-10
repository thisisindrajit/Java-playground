// Question link - https://cses.fi/problemset/task/1071

package cses;

import java.util.Scanner;

public class NumberSpiral {
    public static long findNumber(long x, long y) { 
        if (x >= y) {
            if (x % 2 == 0) {
                return (x * x) + 1 + y;
            } else {
                return (x * x) + (2 * x) + 1 - y;
            }
        } else {
            if (y % 2 == 0) {
                return (y * y) + (2 * y) + 1 - x;
            } else {
                return (y * y) + 1 + x;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long x, y;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            x = sc.nextLong();
            y = sc.nextLong();

            long res = findNumber(x - 1, y - 1);

            sb.append(res);
            sb.append('\n');
        }

        System.out.println(sb.toString());

        sc.close();
    }
}

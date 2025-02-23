// https://leetcode.com/problems/h-index/

package codingproblems;

public class HIndex {
    private static int findHIndex(int[] citations) {
		int[] freq = new int[citations.length + 1];

        for(int c: citations) {
            freq[Math.min(citations.length, c)]++;
        }

        int total = 0;

        for(int i = freq.length - 1; i >= 0; i--) {
            total += freq[i];

            if(total >= i) {
                return i;
            }
        }

        return 0;
	}

	public static void main(String args[]) {
		System.out.println(findHIndex(new int[]{ 3, 0, 6, 1, 5 })); // Should return 3
		System.out.println(findHIndex(new int[]{ 1, 3, 1 })); // Should return 1
	}
}

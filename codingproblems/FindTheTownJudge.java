// https://leetcode.com/problems/find-the-town-judge

package codingproblems;

public class FindTheTownJudge {
    private static int findJudge(int n, int[][] trust) {
        // Visualize this as a graph problem (indegree and outdegree)
        // TC - O(n + m), SC - O(n)
        // n - number of people (vertices), m - length of trust array (edges)
        int[] incomingEdges = new int[n + 1];
        int[] outgoingEdges = new int[n + 1];

        for(int[] t: trust) {
            // Incoming edge of t[1] will be incremented
            incomingEdges[t[1]]++;

            // Outgoing edge of t[0] will be incremented
            outgoingEdges[t[0]]++;
        }

        // Check if any person has n - 1 incoming edges (rule 2) and 0 outgoing edges (rule 1)
        for(int i = 1; i <= n; i++) {
            if(incomingEdges[i] == n - 1 && outgoingEdges[i] == 0) {
                return i;
            }
        }

        return -1;
    }

	public static void main(String args[]) {
		System.out.println(findJudge(3, new int[][]{ { 1, 3 }, { 2, 3 } })); // Should return 3
		System.out.println(findJudge(3, new int[][]{ { 1, 3 }, { 2, 3 }, { 3, 1 } })); // Should return -1
	}    
}

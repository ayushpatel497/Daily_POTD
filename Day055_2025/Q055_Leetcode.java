import java.util.*;

class Q055_Leetcode {
    private List<List<Integer>> tree;
    private int[] distanceFromBob;
    private int n;

    private int findPaths(int sourceNode, int parentNode, int time, int bob, int[] amount) {
        int maxIncome = 0;
        int maxChild = Integer.MIN_VALUE;
        // Set initial distanceFromBob for current node.
        if (sourceNode == bob) {
            distanceFromBob[sourceNode] = 0;
        } else {
            distanceFromBob[sourceNode] = n; // n is an upper bound on distance.
        }
        
        // Recurse for all children (adjacent nodes not equal to parent)
        for (int adjacentNode : tree.get(sourceNode)) {
            if (adjacentNode != parentNode) {
                maxChild = Math.max(maxChild, findPaths(adjacentNode, sourceNode, time + 1, bob, amount));
                distanceFromBob[sourceNode] = Math.min(distanceFromBob[sourceNode], distanceFromBob[adjacentNode] + 1);
            }
        }
        
        // Update income based on Bob's distance and the current time.
        if (distanceFromBob[sourceNode] > time) {
            maxIncome += amount[sourceNode];
        } else if (distanceFromBob[sourceNode] == time) {
            maxIncome += amount[sourceNode] / 2;
        }
        
        // If no child was processed, return current income.
        if (maxChild == Integer.MIN_VALUE)
            return maxIncome;
        else
            return maxIncome + maxChild;
    }
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = amount.length;
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        
        // Build the undirected tree.
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        distanceFromBob = new int[n];
        return findPaths(0, 0, 0, bob, amount);
    }
}

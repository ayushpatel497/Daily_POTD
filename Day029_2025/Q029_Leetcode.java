import java.util.*;
class Q029_Leetcode {
    private int findParent(int node, int[] parent) {
        if (parent[node] == -1) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];  // Since nodes are 1-based

        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = findParent(u, parent);
            int parentV = findParent(v, parent);

            if (parentU == parentV) {
                return edge; // Found the redundant edge
            }

            parent[parentU] = parentV; // Union
        }

        return new int[0]; // No redundant edge found (should not happen in a valid input)
    }
}

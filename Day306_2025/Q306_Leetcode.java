class Q306_Leetcode {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Maximum possible edges in an undirected graph = V*(V-1)/2
        return (V * (V - 1)) / 2 - edges.length;
    }
}

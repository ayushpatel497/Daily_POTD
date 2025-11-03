class Q307_GFG {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] outDegree = new int[V];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            reverseGraph.get(v).add(u);
            outDegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (outDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int parent : reverseGraph.get(node)) {
                outDegree[parent]--;
                if (outDegree[parent] == 0) {
                    q.add(parent);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}

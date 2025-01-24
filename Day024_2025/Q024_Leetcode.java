import java.util.*;

class Q024_Leetcode {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        List<Integer> safeNodes = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            dfs(node, graph, visited, inStack);
        }

        for (int node = 0; node < n; node++) {
            if (!inStack[node]) {
                safeNodes.add(node);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] inStack) {
        if (inStack[node]) {
            return true; // Cycle detected
        }
        if (visited[node]) {
            return false; // Already processed
        }

        visited[node] = true;
        inStack[node] = true;

        for (int neighbor : graph[node]) {
            if (dfs(neighbor, graph, visited, inStack)) {
                return true;
            }
        }

        inStack[node] = false; // Node is safe
        return false;
    }
}

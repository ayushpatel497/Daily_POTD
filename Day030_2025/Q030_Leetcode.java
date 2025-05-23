import java.util.*;

class Q030_Leetcode {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }
        
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int node = 0; node < n; node++) {
            if (colors[node] == -1) {
                colors[node] = 0;
                if (!isBipartite(adjList, node, colors)) {
                    return -1;
                }
            }
        }

        int[] distances = new int[n];
        for (int node = 0; node < n; node++) {
            distances[node] = getLongestShortestPath(adjList, node, n);
        }

        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                maxNumberOfGroups += getNumberOfGroupsForComponent(adjList, node, distances, visited);
            }
        }

        return maxNumberOfGroups;
    }

    private boolean isBipartite(List<List<Integer>> adjList, int node, int[] colors) {
        for (int neighbor : adjList.get(node)) {
            if (colors[neighbor] == colors[node]) {
                return false;
            }
            if (colors[neighbor] == -1) {
                colors[neighbor] = (colors[node] + 1) % 2;
                if (!isBipartite(adjList, neighbor, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getLongestShortestPath(List<List<Integer>> adjList, int srcNode, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(srcNode);
        visited[srcNode] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                int currentNode = queue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return distance;
    }

    private int getNumberOfGroupsForComponent(List<List<Integer>> adjList, int node, int[] distances, boolean[] visited) {
        int maxGroups = distances[node];
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                maxGroups = Math.max(maxGroups, getNumberOfGroupsForComponent(adjList, neighbor, distances, visited));
            }
        }
        return maxGroups;
    }
}

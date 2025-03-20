import java.util.*;

class Q079_Leetcode {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // Create adjacency list
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // Finding components and their cost
        boolean[] visited = new boolean[n];
        int[] components = new int[n];
        List<Integer> componentCost = new ArrayList<>();
        int componentId = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                componentCost.add(getComponentCost(node, adjList, visited, components, componentId));
                componentId++;
            }
        }

        // Answer queries
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int start = query[i][0];
            int end = query[i][1];
            if (components[start] == components[end]) {
                answer[i] = componentCost.get(components[start]);
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }

    private int getComponentCost(int source, List<List<int[]>> adjList, boolean[] visited, int[] components, int componentId) {
        Queue<Integer> queue = new LinkedList<>();
        int componentCost = Integer.MAX_VALUE;
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            components[node] = componentId;

            for (int[] neighbor : adjList.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                componentCost &= weight;

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }

        return componentCost;
    }
}

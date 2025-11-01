import java.util.*;

class Q305_GFG {
    private ArrayList<ArrayList<Integer>> makeGraph(int numTasks, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numTasks; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites)
            graph.get(pre[1]).add(pre[0]);

        return graph;
    }

    private int[] computeIndegree(ArrayList<ArrayList<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        for (ArrayList<Integer> neighbors : graph)
            for (int neigh : neighbors)
                indegree[neigh]++;
        return indegree;
    }

    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = makeGraph(n, prerequisites);
        int[] indegree = computeIndegree(graph);

        Queue<Integer> zeros = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                zeros.add(i);

        ArrayList<Integer> toposort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (zeros.isEmpty())
                return new ArrayList<>(); // Cycle detected
            int zero = zeros.poll();
            toposort.add(zero);
            for (int neigh : graph.get(zero)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    zeros.add(neigh);
            }
        }
        return toposort;
    }
}

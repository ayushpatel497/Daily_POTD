import java.util.*;

class Q091_GFG {
    private void fillAnswer(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> answer, boolean[] visited) {
        visited[node] = true;
        answer.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                fillAnswer(neighbor, adj, answer, visited);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int nodeCount = adj.size();
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[nodeCount];

        for (int node = 0; node < nodeCount; ++node) {
            if (!visited[node]) {
                fillAnswer(node, adj, answer, visited);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Q091_GFG obj = new Q091_GFG();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 3, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1, 5)));
        adj.add(new ArrayList<>(Arrays.asList(1, 2, 5)));
        adj.add(new ArrayList<>(Arrays.asList(3, 4)));

        System.out.println(obj.dfs(adj)); // Example usage
    }
}

import java.util.*;

class Q146_Leetcode {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] count = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
            count[i][colors.charAt(i) - 'a'] = 1;
        }

        int visited = 0, maxCount = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            for (int v : graph.get(u)) {
                for (int c = 0; c < 26; c++) {
                    int add = (colors.charAt(v) - 'a' == c) ? 1 : 0;
                    count[v][c] = Math.max(count[v][c], count[u][c] + add);
                }
                indegree[v]--;
                if (indegree[v] == 0)
                    queue.offer(v);
            }
            for (int c = 0; c < 26; c++)
                maxCount = Math.max(maxCount, count[u][c]);
        }

        return visited == n ? maxCount : -1;
    }
}

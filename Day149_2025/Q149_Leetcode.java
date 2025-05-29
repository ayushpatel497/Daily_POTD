import java.util.*;

class Q149_Leetcode {
    private int dfs(int node, int parent, int depth, List<List<Integer>> children, int[] color) {
        int res = 1 - depth % 2;
        color[node] = depth % 2;
        for (int child : children.get(node)) {
            if (child != parent) {
                res += dfs(child, node, depth + 1, children, color);
            }
        }
        return res;
    }

    private int[] build(int[][] edges, int[] color) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int evenCount = dfs(0, -1, 0, children, color);
        return new int[]{evenCount, n - evenCount};
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] color1 = new int[n];
        int[] color2 = new int[m];

        int[] count1 = build(edges1, color1);
        int[] count2 = build(edges2, color2);

        int maxCount2 = Math.max(count2[0], count2[1]);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[color1[i]] + maxCount2;
        }
        return res;
    }
}

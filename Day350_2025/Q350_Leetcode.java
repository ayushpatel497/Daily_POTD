import java.util.*;

class Q350_Leetcode {
    static class Result {
        int[] dp0, dp1;
        int size;
        Result(int[] dp0, int[] dp1, int size) {
            this.dp0 = dp0;
            this.dp1 = dp1;
            this.size = size;
        }
    }

    int B;
    List<Integer>[] graph;
    int[] present, future;

    Result dfs(int u) {
        int cost = present[u];
        int dCost = cost / 2;

        int[] sub0 = new int[B + 1];
        int[] sub1 = new int[B + 1];
        int size = cost;

        for (int v : graph[u]) {
            Result r = dfs(v);
            size += r.size;

            int[] nsub0 = new int[B + 1];
            int[] nsub1 = new int[B + 1];

            for (int i = 0; i <= B; i++) {
                for (int j = 0; j <= Math.min(i, r.size); j++) {
                    nsub0[i] = Math.max(nsub0[i], sub0[i - j] + r.dp0[j]);
                    nsub1[i] = Math.max(nsub1[i], sub1[i - j] + r.dp1[j]);
                }
            }
            sub0 = nsub0;
            sub1 = nsub1;
        }

        int[] dp0 = new int[B + 1];
        int[] dp1 = new int[B + 1];

        for (int i = 0; i <= B; i++) {
            dp0[i] = dp1[i] = sub0[i];

            if (i >= dCost) {
                dp1[i] = Math.max(dp1[i],
                        sub1[i - dCost] + future[u] - dCost);
            }
            if (i >= cost) {
                dp0[i] = Math.max(dp0[i],
                        sub1[i - cost] + future[u] - cost);
            }
        }
        return new Result(dp0, dp1, size);
    }

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.B = budget;
        this.present = present;
        this.future = future;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : hierarchy) {
            graph[e[0] - 1].add(e[1] - 1);
        }

        return dfs(0).dp0[budget];
    }
}

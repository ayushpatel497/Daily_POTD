import java.util.Arrays;

class Q167_GFG {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> Integer.compare(heights[a], heights[b]));

        long sufCost = 0, sufProdSum = 0;
        for (int i = 0; i < n; i++) {
            sufCost += cost[idx[i]];
            sufProdSum += 1L * heights[idx[i]] * cost[idx[i]];
        }

        long preCost = 0, preProdSum = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            preCost += cost[idx[i]];
            preProdSum += 1L * heights[idx[i]] * cost[idx[i]];
            sufCost -= cost[idx[i]];
            sufProdSum -= 1L * heights[idx[i]] * cost[idx[i]];

            long h = heights[idx[i]];
            long totalCost = (h * preCost - preProdSum) + (sufProdSum - h * sufCost);
            ans = Math.min(ans, totalCost);
        }

        return (int) ans;
    }
}

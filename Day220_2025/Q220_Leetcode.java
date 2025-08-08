import java.util.*;

class Q220_Leetcode {
    public double soupServings(int n) {
        int m = (int) Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();

        // Recursive function with memoization
        java.util.function.BiFunction<Integer, Integer, Double> calculateDP = new java.util.function.BiFunction<>() {
            @Override
            public Double apply(Integer i, Integer j) {
                if (i <= 0 && j <= 0) {
                    return 0.5;
                }
                if (i <= 0) {
                    return 1.0;
                }
                if (j <= 0) {
                    return 0.0;
                }
                if (dp.containsKey(i) && dp.get(i).containsKey(j)) {
                    return dp.get(i).get(j);
                }
                double value = (
                        this.apply(i - 4, j) +
                        this.apply(i - 3, j - 1) +
                        this.apply(i - 2, j - 2) +
                        this.apply(i - 1, j - 3)
                ) / 4.0;
                dp.computeIfAbsent(i, _ -> new HashMap<>()).put(j, value);
                return value;
            }
        };

        for (int k = 1; k <= m; k++) {
            if (calculateDP.apply(k, k) > 1 - 1e-5) {
                return 1.0;
            }
        }
        return calculateDP.apply(m, m);
    }
}

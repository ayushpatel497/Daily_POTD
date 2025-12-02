import java.util.HashMap;
import java.util.Map;

class Q336_Leetcode {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1000000007L;

        Map<Integer, Integer> pointNum = new HashMap<>();
        long ans = 0, sum = 0;

        // Count how many points lie on each horizontal line (same y-coordinate)
        for (int[] point : points) {
            int y = point[1];
            pointNum.put(y, pointNum.getOrDefault(y, 0) + 1);
        }

        // For each horizontal line
        for (int pNum : pointNum.values()) {

            long edge = (long)pNum * (pNum - 1) / 2;  // nC2

            ans = (ans + edge * sum) % MOD;
            sum = (sum + edge) % MOD;
        }

        return (int) ans;
    }
}

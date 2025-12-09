import java.util.*;

class Q343_Leetcode {
    public int specialTriplets(int[] nums) {
        final int MOD = 1000000007;

        HashMap<Integer, Integer> numCnt = new HashMap<>();
        HashMap<Integer, Integer> numPartialCnt = new HashMap<>();

        // Count full frequency of each number
        for (int v : nums) {
            numCnt.put(v, numCnt.getOrDefault(v, 0) + 1);
        }

        long ans = 0;

        for (int v : nums) {
            int target = v * 2;

            int lCnt = numPartialCnt.getOrDefault(target, 0);

            // Mark v as processed partially (left side)
            numPartialCnt.put(v, numPartialCnt.getOrDefault(v, 0) + 1);

            int rCnt = numCnt.getOrDefault(target, 0) - numPartialCnt.getOrDefault(target, 0);

            ans = (ans + (long) lCnt * rCnt) % MOD;
        }

        return (int) ans;
    }
}

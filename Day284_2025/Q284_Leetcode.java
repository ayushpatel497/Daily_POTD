import java.util.*;

class Q284_Leetcode {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int p : power) {
            count.put(p, count.getOrDefault(p, 0) + 1);
        }

        List<int[]> vec = new ArrayList<>();
        vec.add(new int[]{(int)-1e9, 0});  // Sentinel value
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            vec.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int n = vec.size();
        long[] f = new long[n];
        long mx = 0;

        for (int i = 1, j = 1; i < n; i++) {
            while (j < i && vec.get(j)[0] < vec.get(i)[0] - 2) {
                mx = Math.max(mx, f[j]);
                j++;
            }
            f[i] = mx + 1L * vec.get(i)[0] * vec.get(i)[1];
        }

        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, f[i]);
        }

        return ans;
    }
}

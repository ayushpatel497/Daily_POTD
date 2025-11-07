import java.util.*;

class Q311_Leetcode {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] count = new long[n + 1];
        
        // Build prefix-difference array for station ranges
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n, i + r + 1);
            count[left] += stations[i];
            count[right] -= stations[i];
        }

        // Helper function using lambda-like approach
        class Checker {
            boolean check(long value) {
                long[] diff = Arrays.copyOf(count, count.length);
                long sum = 0;
                long remaining = k;

                for (int i = 0; i < n; i++) {
                    sum += diff[i];
                    if (sum < value) {
                        long add = value - sum;
                        if (remaining < add) return false;
                        remaining -= add;
                        int end = Math.min(n, i + 2 * r + 1);
                        diff[end] -= add;
                        sum += add;
                    }
                }
                return true;
            }
        }

        Checker checker = new Checker();
        long low = Arrays.stream(stations).min().getAsInt();
        long high = Arrays.stream(stations).asLongStream().sum() + k;
        long result = 0;

        // Binary search on the answer
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (checker.check(mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}

import java.util.*;

class Q362_GFG {

    private long numberOfDonuts(long t, int[] ranks) {
        long donuts = 0;
        for (int r : ranks) {
            donuts += (long)((Math.sqrt(1 + 8.0 * t / r) - 1) / 2);
        }
        return donuts;
    }

    public int minTime(int[] ranks, int n) {
        long low = 0;
        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }

        long high = (long) n * (n + 1) / 2 * minRank;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (numberOfDonuts(mid, ranks) >= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}

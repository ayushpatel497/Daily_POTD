import java.util.Arrays;

class Q162_Leetcode {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);

                int cnt_a = 0, cnt_b = 0;
                int prev_a = 0, prev_b = 0;
                int left = -1;

                for (int right = 0; right < n; right++) {
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        int leftStatus = ((prev_a & 1) << 1) | (prev_b & 1);
                        best[leftStatus] = Math.min(best[leftStatus], prev_a - prev_b);
                        left++;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int rightStatus = ((cnt_a & 1) << 1) | (cnt_b & 1);
                    int opposite = rightStatus ^ 0b10;

                    if (best[opposite] != Integer.MAX_VALUE) {
                        ans = Math.max(ans, cnt_a - cnt_b - best[opposite]);
                    }
                }
            }
        }

        return ans;
    }
}

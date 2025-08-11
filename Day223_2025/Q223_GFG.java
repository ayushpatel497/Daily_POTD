public class Q223_GFG {
    public int maxSum(String s) {
        int n = s.length();
        if (n < 2) return 0;

        int[] rad = new int[n];
        int L = 0, R = -1;
        for (int i = 0; i < n; ++i) {
            int k = (i > R) ? 1 : Math.min(rad[L + R - i], R - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) ++k;
            rad[i] = k;
            if (i + k - 1 > R) {
                L = i - k + 1;
                R = i + k - 1;
            }
        }

        int[] bestEnd = new int[n];
        int[] bestStart = new int[n];
        for (int c = 0; c < n; ++c) {
            int len = 2 * rad[c] - 1;
            int l = c - rad[c] + 1;
            int r = c + rad[c] - 1;
            bestEnd[r] = Math.max(bestEnd[r], len);
            bestStart[l] = Math.max(bestStart[l], len);
        }

        for (int i = n - 2; i >= 0; --i)
            bestEnd[i] = Math.max(bestEnd[i], bestEnd[i + 1] - 2);

        for (int i = 1; i < n; ++i)
            bestStart[i] = Math.max(bestStart[i], bestStart[i - 1] - 2);

        int bestLeft = 0, ans = 0;
        for (int i = 0; i + 1 < n; ++i) {
            bestLeft = Math.max(bestLeft, bestEnd[i]);
            ans = Math.max(ans, bestLeft + bestStart[i + 1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Q223_GFG sol = new Q223_GFG();
        String s = "abacaba";
        System.out.println(sol.maxSum(s)); // Example test
    }
}

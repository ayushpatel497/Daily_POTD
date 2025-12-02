class Q336_GFG {

    int solve(int ind, String s, List<List<Integer>> adj, int[] pref, int[][] nextPos, int[] dp) {
        if (ind == s.length() - 1) {
            return 0;
        }

        if (dp[ind] != -1) return dp[ind];

        int best = 0;
        int curr = s.charAt(ind) - 'a';

        for (int targetChar : adj.get(curr)) {

            int jumpInd = nextPos[ind][targetChar - 'a'];
            if (jumpInd == -1) continue;

            int gain;
            if (targetChar == s.charAt(ind)) {
                gain = pref[jumpInd] - pref[ind + 1];
            } else {
                gain = pref[jumpInd] - pref[ind];
            }

            gain += solve(jumpInd, s, adj, pref, nextPos, dp);
            best = Math.max(best, gain);
        }

        return dp[ind] = best;
    }

    public int maxScore(String s, char[][] jumps) {

        int n = s.length();

        // Add (c -> c) for all characters
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        for (char[] p : jumps) {
            adj.get(p[0] - 'a').add((int) p[1]);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            adj.get(c - 'a').add((int) c);
        }

        int[][] nextPos = new int[n][26];
        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                nextPos[i][c] = last[c];
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + s.charAt(i);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, adj, pref, nextPos, dp);
    }
}

import java.util.*;

class Q085_GFG {
    public boolean wordBreak(String s, List<String> dictionary) {
        int n = s.length();
        // Set<String> wordSet = new HashSet<>(dictionary); // Using a HashSet for O(1) lookups
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : dictionary) {
                int start = i - word.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

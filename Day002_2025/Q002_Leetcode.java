import java.util.*;

class Q002_Leetcode {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private boolean check(String s) {
        return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        // Q. Count Vowel Strings in Ranges
        int n = words.length;
        int[] preSum = new int[n + 1];
        int[] ans = new int[queries.length];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (check(words[i]) ? 1 : 0);
        }

        for (int j = 0; j < queries.length; j++) {
            int low = queries[j][0];
            int up = queries[j][1];
            ans[j] = preSum[up + 1] - preSum[low];
        }

        return ans;
    }

    public static void main(String[] args) {
        Q002_Leetcode sol = new Q002_Leetcode();

        // Example input
        String[] words = {"apple", "orange", "idea", "umbrella", "eagle"};
        int[][] queries = {{0, 2}, {1, 4}, {0, 4}};
        
        // Output results
        int[] result = sol.vowelStrings(words, queries);
        System.out.println("Results: " + Arrays.toString(result));
    }
}

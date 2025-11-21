class Q325_Leetcode {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        // Initialize first occurrences to large value
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(last, -1);

        // Find first and last occurrences
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            first[idx] = Math.min(first[idx], i);
            last[idx] = i;
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            if (first[i] < last[i]) {
                HashSet<Character> set = new HashSet<>();

                // Collect unique middle characters
                for (int j = first[i] + 1; j < last[i]; j++) {
                    set.add(s.charAt(j));
                }

                ans += set.size();
            }
        }

        return ans;
    }
}

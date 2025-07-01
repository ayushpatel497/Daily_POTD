class Q182_GFG {
    public int substrCount(String s, int k) {
        int n = s.length();
        if (k > n) return 0;

        int ans = 0;
        for (int i = 0; i <= n - k; i++) {
            String temp = s.substring(i, i + k);
            if (isValid(temp, k - 1)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isValid(String temp, int val) {
        int[] freq = new int[26];
        int unique = 0;

        for (char ch : temp.toCharArray()) {
            if (freq[ch - 'a'] == 0) unique++;
            freq[ch - 'a']++;
        }
        return unique == val;
    }
}

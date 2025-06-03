class Q154_GFG {
    private int count(String s, int k) {
        int n = s.length();
        int ans = 0;
        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1) distinctCnt++;

            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0) distinctCnt--;
                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }

    public int countSubstr(String s, int k) {
        return count(s, k) - count(s, k - 1);
    }
}

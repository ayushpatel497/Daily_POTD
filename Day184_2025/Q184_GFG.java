class Q184_GFG {
    public int longestKSubstr(String s, int k) {
        int[] freq = new int[26];
        int cnt = 0;
        int st = 0;
        int ans = -1;

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a']++ == 0) {
                cnt++;
                if (cnt > k) {
                    ans = Math.max(ans, i - st);
                    while (st < i) {
                        if (--freq[s.charAt(st++) - 'a'] == 0) {
                            cnt--;
                            break;
                        }
                    }
                }
            }
        }

        if (cnt >= k) {
            ans = Math.max(ans, s.length() - st);
        }

        return ans;
    }
}

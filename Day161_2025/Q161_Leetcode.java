class Q161_Leetcode {
    public int maxDifference(String s) {
        int odd = -1;
        int even = Integer.MAX_VALUE;
        int[] frq = new int[26];

        for (char c : s.toCharArray()) {
            frq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frq[i] % 2 == 1) {
                odd = Math.max(odd, frq[i]);
            } else if (frq[i] != 0) {
                even = Math.min(even, frq[i]);
            }
        }

        return odd - even;
    }
}

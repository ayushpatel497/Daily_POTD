class Q065_GFG {
    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[] next = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    cur[j] = 1 + next[j + 1];
                else
                    cur[j] = Math.max(next[j], cur[j + 1]);
            }
            next = cur.clone();
        }

        return next[0];
    }
}

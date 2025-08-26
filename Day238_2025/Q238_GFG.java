class Q238_GFG {
    public boolean isSubSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == n;
    }
}

class Q184_Leetcode {
    public char kthCharacter(int k) {
        int ans = 0;
        while (k != 1) {
            int t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k -= (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}

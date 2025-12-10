class Q344_Leetcode {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        // If any element after index 0 is <= complexity[0], return 0
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, complexity[i]);
        }
        if (min <= complexity[0]) return 0;

        long mod = 1000000007;
        long ans = 1;

        for (int i = 2; i < n; i++) {
            ans = (ans * i) % mod;
        }

        return (int) ans;
    }
}

class Q327_Leetcode {
    public int maxSumDivThree(int[] nums) {
        int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] g = f.clone();
            int rem = num % 3;

            for (int i = 0; i < 3; i++) {
                int newRem = (i + rem) % 3;
                g[newRem] = Math.max(g[newRem], f[i] + num);
            }
            f = g;
        }
        return f[0];
    }
}

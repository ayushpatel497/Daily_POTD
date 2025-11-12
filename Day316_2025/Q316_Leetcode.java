class Q316_Leetcode {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int num1 = 0;
        int g = 0;

        for (int x : nums) {
            if (x == 1) num1++;
            g = gcd(g, x);
        }

        if (num1 > 0) return n - num1;
        if (g > 1) return -1;

        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currG = 0;
            for (int j = i; j < n; j++) {
                currG = gcd(currG, nums[j]);
                if (currG == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;
    }
}

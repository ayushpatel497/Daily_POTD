class Q326_Leetcode {
    public int minimumOperations(int[] nums) {
        int ans = 0;

        for (int v : nums) {
            int mod = v % 3;
            ans += Math.min(mod, 3 - mod);
        }
        return ans;
    }
}

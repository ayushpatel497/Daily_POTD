class Q097_Leetcode {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        int target = total / 2;

        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];
        prev[0] = true;
        curr[0] = true;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int t = 0; t <= target; t++) {
                boolean include = (t - nums[i] >= 0) ? prev[t - nums[i]] : false;
                boolean exclude = prev[t];
                curr[t] = include || exclude;
            }
            prev = curr.clone();
        }

        return prev[target];
    }
}

class Q118_Leetcode {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long res = 0, total = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            total += nums[j];
            while (i <= j && total * (j - i + 1) >= k) {
                total -= nums[i];
                i++;
            }
            res += j - i + 1;
        }

        return res;
    }
}

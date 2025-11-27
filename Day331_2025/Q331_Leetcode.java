class Q331_Leetcode {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;

        long[] kSum = new long[k];
        for (int i = 0; i < k; i++)
            kSum[i] = Long.MAX_VALUE / 2;

        kSum[k - 1] = 0; // base case for empty prefix

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int mod = i % k;
            maxSum = Math.max(maxSum, prefixSum - kSum[mod]);

            kSum[mod] = Math.min(kSum[mod], prefixSum);
        }

        return maxSum;
    }
}

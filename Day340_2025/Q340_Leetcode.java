class Q340_Leetcode {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = 1000000007L;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        dp[0] = 1;
        prefix[0] = 1;

        int j = 0;

        for (int i = 0; i < n; i++) {

            // maintain max deque (decreasing)
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i])
                maxQ.pollLast();
            maxQ.addLast(i);

            // maintain min deque (increasing)
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i])
                minQ.pollLast();
            minQ.addLast(i);

            // shrink window while max-min > k
            while (!maxQ.isEmpty() && !minQ.isEmpty()
                    && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {

                if (maxQ.peekFirst() == j)
                    maxQ.pollFirst();
                if (minQ.peekFirst() == j)
                    minQ.pollFirst();

                j++;
            }

            long val = prefix[i] - (j > 0 ? prefix[j - 1] : 0);
            val = (val % mod + mod) % mod;

            dp[i + 1] = val;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }
}

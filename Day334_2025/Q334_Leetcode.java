class Q334_Leetcode {
    public int minSubarray(int[] nums, int p) {

        int n = nums.length;
        long totalSum = 0;

        for (int num : nums)
            totalSum = (totalSum + num) % p;

        int target = (int)(totalSum % p);
        if (target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long curr = 0;
        int minLen = n;

        for (int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            int need = (int)((curr - target + p) % p);

            if (map.containsKey(need)) {
                minLen = Math.min(minLen, i - map.get(need));
            }

            map.put((int)curr, i);
        }

        return minLen == n ? -1 : minLen;
    }
}

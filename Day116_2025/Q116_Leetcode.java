class Q116_Leetcode {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minPos = -1, maxPos = -1, leftBound = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                minPos = i;
            }
            if (nums[i] == maxK) {
                maxPos = i;
            }
            int count = Math.min(minPos, maxPos) - leftBound;
            ans += (count <= 0) ? 0 : count;
        }
        
        return ans;
    }
}

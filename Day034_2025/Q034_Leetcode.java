class Q034_Leetcode {
    public int longestMonotonicSubarray(int[] nums) {
        int increasingLength = 1, decreasingLength = 1, maxLength = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasingLength += 1;
                decreasingLength = 1;
            } else if (nums[i] < nums[i - 1]) {
                decreasingLength += 1;
                increasingLength = 1;
            } else {
                increasingLength = 1;
                decreasingLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(increasingLength, decreasingLength));
        }
        return maxLength;
    }
}

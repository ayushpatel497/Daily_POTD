class Q236_Leetcode {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int longestWindow = 0;
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
            
            while (zeroCount > 1) {
                if (nums[start] == 0) zeroCount--;
                start++;
            }
            
            longestWindow = Math.max(longestWindow, i - start);
        }
        
        return longestWindow;
    }
}


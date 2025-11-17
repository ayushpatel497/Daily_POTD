class Q321_Leetcode {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int prev = -1; 
        boolean first = true;

        for (int i = 0; i < n; i++) {
            if (first && nums[i] == 1) {
                prev = i;
                first = false;
            } 
            else if (nums[i] == 1) {
                if (i - prev - 1 < k) return false;
                prev = i;
            }
        }
        return true;
    }
}

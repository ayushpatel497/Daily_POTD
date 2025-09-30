class Q273_Leetcode {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; // reduce array size by 1
        }

        return nums[0];
    }
}

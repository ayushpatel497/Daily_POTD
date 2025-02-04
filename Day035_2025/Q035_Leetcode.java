class Q035_Leetcode {
    public int maxAscendingSum(int[] nums) {
        int maximumAscendingSum = nums[0];
        int currentAscendingSum = nums[0];

        for (int index = 1; index < nums.length; ++index) {
            if (nums[index] > nums[index - 1]) {
                currentAscendingSum += nums[index];
            } else {
                maximumAscendingSum = Math.max(maximumAscendingSum, currentAscendingSum);
                currentAscendingSum = nums[index];
            }
        }
        return Math.max(maximumAscendingSum, currentAscendingSum);
    }
}

class Q209_Leetcode {
    private int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        backtrack(nums, 0, 0, maxOR);
        return count;
    }

    private void backtrack(int[] nums, int index, int currentOR, int maxOR) {
        if (index == nums.length) {
            if (currentOR == maxOR) {
                count++;
            }
            return;
        }

        // Include current element
        backtrack(nums, index + 1, currentOR | nums[index], maxOR);

        // Exclude current element
        backtrack(nums, index + 1, currentOR, maxOR);
    }
}

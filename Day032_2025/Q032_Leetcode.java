class Q032_Leetcode {
    private boolean isOdd(int number) {
        return (number & 1) == 1;
    }

    public boolean isArraySpecial(int[] nums) {
        int numsSize = nums.length;
        if (numsSize == 1) {
            return true;
        }

        for (int i = 1; i < numsSize; i++) {
            if ((isOdd(nums[i]) && isOdd(nums[i - 1])) || (!isOdd(nums[i]) && !isOdd(nums[i - 1]))) {
                return false;
            }
        }
        return true;
    }
}

class Q033_Leetcode {
    public boolean check(int[] nums) {
        int count = 0, numsSize = nums.length;

        for (int i = 0; i < numsSize; i++) {
            if (nums[i] > nums[(i + 1) % numsSize]) {
                count++;
            }
        }
        return count <= 1;
    }
}

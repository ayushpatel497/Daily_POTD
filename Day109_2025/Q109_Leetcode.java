import java.util.Arrays;

class Q109_Leetcode {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLessThan(nums, upper + 1) - countLessThan(nums, lower);
    }

    private long countLessThan(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < value) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}

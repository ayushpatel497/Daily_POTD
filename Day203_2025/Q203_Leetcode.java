import java.util.*;

class Q203_Leetcode {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, currentSum = 0, maxSum = 0;

        for (int right = 0; right < nums.length; ++right) {
            while (seen.contains(nums[right])) {
                currentSum -= nums[left];
                seen.remove(nums[left]);
                ++left;
            }
            currentSum += nums[right];
            seen.add(nums[right]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

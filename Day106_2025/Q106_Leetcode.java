import java.util.*;
class Q106_Leetcode {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int same = 0, right = -1;
        Map<Integer, Integer> count = new HashMap<>();

        for (int left = 0; left < n; left++) {
            while (same < k && right + 1 < n) {
                right++;
                same += count.getOrDefault(nums[right], 0);
                count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            }
            if (same >= k) {
                ans += n - right;
            }
            count.put(nums[left], count.get(nums[left]) - 1);
            same -= count.get(nums[left]);
        }

        return ans;
    }
}

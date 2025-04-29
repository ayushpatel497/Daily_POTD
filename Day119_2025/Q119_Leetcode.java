import java.util.Arrays;

class Q119_Leetcode {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int start = 0;
        int maxCount = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                maxCount++;
            }

            while (maxCount == k) {
                if (nums[start] == maxElement) {
                    maxCount--;
                }
                start++;
            }

            ans += start;
        }

        return ans;
    }
}

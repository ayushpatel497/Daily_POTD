import java.util.Arrays;

class Q164_Leetcode {

    private int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++; // skip the paired element
            }
            index++; // move to next element
        }
        return count;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countValidPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

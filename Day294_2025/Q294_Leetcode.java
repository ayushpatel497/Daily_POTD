import java.util.*;

class Q294_Leetcode {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> numCount = new HashMap<>();

        int lastNumIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                numCount.put(nums[lastNumIndex], i - lastNumIndex);
                ans = Math.max(ans, i - lastNumIndex);
                lastNumIndex = i;
            }
        }

        numCount.put(nums[lastNumIndex], nums.length - lastNumIndex);
        ans = Math.max(ans, nums.length - lastNumIndex);

        // left bound
        java.util.function.IntFunction<Integer> leftBound = (value) -> {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < value) left = mid + 1;
                else right = mid;
            }
            return left;
        };

        // right bound
        java.util.function.IntFunction<Integer> rightBound = (value) -> {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] > value) right = mid - 1;
                else left = mid;
            }
            return left;
        };

        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            int l = leftBound.apply(i - k);
            int r = rightBound.apply(i + k);

            int tempAns;
            if (numCount.containsKey(i))
                tempAns = Math.min(r - l + 1, numCount.get(i) + numOperations);
            else
                tempAns = Math.min(r - l + 1, numOperations);

            ans = Math.max(ans, tempAns);
        }

        return ans;
    }
}

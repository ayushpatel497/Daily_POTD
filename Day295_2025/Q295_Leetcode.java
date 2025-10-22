import java.util.*;

class Q295_Leetcode {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        TreeSet<Integer> modes = new TreeSet<>();

        // Helper to add mode and its variants
        java.util.function.Consumer<Integer> addMode = (value) -> {
            modes.add(value);
            if (value - k >= nums[0]) {
                modes.add(value - k);
            }
            if (value + k <= nums[nums.length - 1]) {
                modes.add(value + k);
            }
        };

        int lastNumIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[lastNumIndex]) {
                numCount.put(nums[lastNumIndex], i - lastNumIndex);
                ans = Math.max(ans, i - lastNumIndex);
                addMode.accept(nums[lastNumIndex]);
                lastNumIndex = i;
            }
        }

        numCount.put(nums[lastNumIndex], nums.length - lastNumIndex);
        ans = Math.max(ans, nums.length - lastNumIndex);
        addMode.accept(nums[lastNumIndex]);

        // Left bound (first index >= value)
        java.util.function.IntFunction<Integer> leftBound = (value) -> {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < value)
                    left = mid + 1;
                else
                    right = mid;
            }
            return left;
        };

        // Right bound (last index <= value)
        java.util.function.IntFunction<Integer> rightBound = (value) -> {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] > value)
                    right = mid - 1;
                else
                    left = mid;
            }
            return left;
        };

        for (int mode : modes) {
            int l = leftBound.apply(mode - k);
            int r = rightBound.apply(mode + k);
            int tempAns;

            if (numCount.containsKey(mode)) {
                tempAns = Math.min(r - l + 1, numCount.get(mode) + numOperations);
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }

            ans = Math.max(ans, tempAns);
        }

        return ans;
    }
}

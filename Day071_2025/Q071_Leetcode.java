class Q071_Leetcode {
    public int maximumCount(int[] nums) {
        int posCount = 0, negCount = 0;
        int left = 0, right = nums.length - 1;

        // Count negatives using binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
                negCount = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        // Count positives using binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
                posCount = nums.length - mid;
            }
        }

        return Math.max(posCount, negCount);
    }
}

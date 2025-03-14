class Q073_Leetcode {
    public int maximumCandies(int[] candies, long k) {
        int left = 0, right = 0;
        
        // Find the maximum number of candies in any pile
        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2; // Upper middle to prevent infinite loops

            if (isValid(candies, k, mid)) {
                left = mid; // Increase lower bound if valid
            } else {
                right = mid - 1; // Decrease upper bound if invalid
            }
        }

        return left;
    }

    private boolean isValid(int[] candies, long k, int mid) {
        if (mid == 0) return false; // Avoid division by zero
        
        long maxNumOfChildren = 0;

        for (int candy : candies) {
            maxNumOfChildren += candy / mid;
        }

        return maxNumOfChildren >= k;
    }
}

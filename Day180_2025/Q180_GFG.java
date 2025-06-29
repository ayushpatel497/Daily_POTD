class Q180_GFG {
    private boolean isFeasible(int[] arr, int k, int maxSum) {
        int sum = 0;
        int count = 1;
        for (int num : arr) {
            sum += num;
            if (sum > maxSum) {
                sum = num;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }

    public int splitArray(int[] arr, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : arr) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isFeasible(arr, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

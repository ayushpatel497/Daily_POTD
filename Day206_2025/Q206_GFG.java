class Q206_GFG {
    public int maxCircularSum(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        int currMax = arr[0], maxSum = arr[0];
        int currMin = arr[0], minSum = arr[0];

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];

            if (i > 0) {
                currMax = Math.max(arr[i], currMax + arr[i]);
                maxSum = Math.max(maxSum, currMax);

                currMin = Math.min(arr[i], currMin + arr[i]);
                minSum = Math.min(minSum, currMin);
            }
        }

        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
}

class Q216_GFG {
    public int maxRectSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < m; left++) {
            int[] temp = new int[n];

            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][right];
                }

                // Apply Kadane's algorithm on temp[]
                int currSum = 0, best = Integer.MIN_VALUE;
                for (int val : temp) {
                    currSum += val;
                    best = Math.max(best, currSum);
                    if (currSum < 0) currSum = 0;
                }

                maxSum = Math.max(maxSum, best);
            }
        }

        return maxSum;
    }
}

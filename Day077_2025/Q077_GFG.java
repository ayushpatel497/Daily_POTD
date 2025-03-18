class Q077_GFG {
    public static boolean canPartition(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 2;
        boolean[][] memo = new boolean[n + 1][targetSum + 1];

        return subsetSum(0, n, targetSum, arr, memo);
    }

    private static boolean subsetSum(int pos, int n, int sum, int[] arr, boolean[][] memo) {
        if (sum < 0) return false;
        if (pos == n) return sum == 0;
        if (memo[pos][sum]) return true;
        
        return memo[pos][sum] = subsetSum(pos + 1, n, sum - arr[pos], arr, memo) || subsetSum(pos + 1, n, sum, arr, memo);
    }
}

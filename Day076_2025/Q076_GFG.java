class Q076_GFG {
    public static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];

        prev[0] = true; // Base case: sum 0 is always possible

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    curr[j] = prev[j];
                } else {
                    curr[j] = prev[j] || prev[j - arr[i - 1]];
                }
            }
            prev = curr.clone(); // Copy current row to previous
        }

        return prev[sum];
    }
}

class Q186_GFG {
    public int maxSum(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n; i++) {
            int temp = arr[i] + arr[i - 1];
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}

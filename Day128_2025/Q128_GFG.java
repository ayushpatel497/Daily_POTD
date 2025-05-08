class Q128_GFG {
    public int findMissing(int[] arr) {
        int n = arr.length;
        int d = Integer.MAX_VALUE;

        // Find the minimum common difference
        for (int i = 1; i < n; i++) {
            d = Math.min(d, arr[i] - arr[i - 1]);
        }

        // Identify the missing element using the difference
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return arr[i - 1] + d;
            }
        }

        // If not found in loop, it's at the end
        return arr[n - 1] + d;
    }
}

class Q360_GFG {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int ans = n;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // missing numbers till index mid
            if (arr[mid] - mid - 1 >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans + k;
    }
}

class Q122_GFG {
    public int findMaximum(int[] arr) {
        int n = arr.length;

        if (n == 1) return arr[0];
        if (arr[0] > arr[1]) return arr[0];
        if (arr[n - 1] > arr[n - 2]) return arr[n - 1];

        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid > 0 && mid < n - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return arr[mid];
            else if (mid < n - 1 && arr[mid] < arr[mid + 1])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;  // Bitonic point not found (ideally shouldn't happen)
    }
}

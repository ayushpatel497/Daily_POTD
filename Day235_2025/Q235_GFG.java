class Q235_GFG {
    private boolean isPossible(int[] arr, int k, int pageLimit) {
        int count = 1;
        int pageSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pageSum + arr[i] > pageLimit) {
                count++;
                pageSum = arr[i];
            } else {
                pageSum += arr[i];
            }
        }
        return count <= k;
    }

    public int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;

        int start = 0, end = 0;
        for (int num : arr) {
            start = Math.max(start, num);
            end += num;
        }

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(arr, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}

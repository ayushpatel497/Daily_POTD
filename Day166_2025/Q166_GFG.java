class Q166_GFG {
    private boolean isPossible(int[] arr, int k, int val) {
        int sum = 0;
        for (int num : arr) {
            sum += (int) Math.ceil((double) num / val);
        }
        return sum <= k;
    }

    public int smallestDivisor(int[] arr, int k) {
        int start = 1;
        int end = 0;
        for (int num : arr) {
            end = Math.max(end, num);
        }

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
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

class Q181_GFG {
    private boolean canReachHeight(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] water = new int[n + 1];
        long ops = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            curr += water[i];
            int effectiveHeight = arr[i] + (int)curr;

            if (effectiveHeight < target) {
                int add = target - effectiveHeight;
                ops += add;
                if (ops > k) return false;

                curr += add;
                if (i + w < n) {
                    water[i + w] -= add;
                }
            }
        }

        return true;
    }

    public int maxMinHeight(int[] arr, int k, int w) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) min = Math.min(min, num);

        int low = min, high = min + k;
        int answer = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReachHeight(arr, k, w, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}

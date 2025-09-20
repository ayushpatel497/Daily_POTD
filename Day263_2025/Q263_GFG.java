class Q263_GFG {
    private int f(int st, int e, int[] arr) {
        for (int i = st; i <= e; i++) {
            if (arr[i] > e - st + 1) {
                return Math.max(f(st, i - 1, arr), f(i + 1, e, arr));
            }
        }
        return e - st + 1;
    }

    public int longestSubarray(int[] arr) {
        int n = arr.length;
        return f(0, n - 1, arr);
    }
}

class Q363_GFG {
    public int kthElement(int[] a, int[] b, int k) {
        int i = 0, j = 0;
        int ans = 0;

        while (k > 0 && i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                ans = a[i++];
            } else {
                ans = b[j++];
            }
            k--;
            if (k == 0) return ans;
        }

        if (i < a.length) return a[i + k - 1];
        if (j < b.length) return b[j + k - 1];

        return -1;
    }
}

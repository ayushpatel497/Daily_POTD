class Q160_Leetcode {
    private int countNumbersWithPrefix(long prefix, int n) {
        long curr = prefix, next = prefix + 1;
        int count = 0;
        while (curr <= n) {
            count += (int) (Math.min(n + 1L, next) - curr);
            curr *= 10;
            next *= 10;
        }
        return count;
    }

    public int findKthNumber(int n, int k) {
        int currentPrefix = 1;
        k--;  // We already consider 1 as the first number

        while (k > 0) {
            int count = countNumbersWithPrefix(currentPrefix, n);
            if (k >= count) {
                currentPrefix++;
                k -= count;
            } else {
                currentPrefix *= 10;
                k--;
            }
        }

        return currentPrefix;
    }
}

class Q251_Leetcode {
    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (Integer.toString(A).indexOf('0') == -1 && Integer.toString(B).indexOf('0') == -1) {
                return new int[] {A, B};
            }
        }
        return new int[] {}; // fallback, though guaranteed by problem constraints
    }
}

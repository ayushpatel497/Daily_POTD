class Q329_Leetcode {
    public int smallestRepunitDivByK(int k) {
        // If k is divisible by 2 or 5, no repunit number can be divisible.
        if (k % 2 == 0 || k % 5 == 0) 
            return -1;

        int remainder = 0;
        for (int length_N = 1; length_N <= k; length_N++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return length_N;
            }
        }
        return -1;
    }
}

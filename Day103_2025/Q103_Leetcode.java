class Q103_Leetcode {
    static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) (modPow(5, (n + 1) / 2) * modPow(4, n / 2) % MOD);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}

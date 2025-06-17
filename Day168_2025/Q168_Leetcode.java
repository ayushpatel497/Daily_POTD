class Q168_Leetcode {
    static final int MOD = (int)1e9 + 7;
    static final int MX = 100005;
    static long[] fact = new long[MX];
    static long[] invFact = new long[MX];
    static boolean initialized = false;

    void init() {
        if (initialized) return;
        initialized = true;

        fact[0] = 1;
        for (int i = 1; i < MX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }
    }

    long qpow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }

    long comb(int n, int r) {
        if (r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        init();
        long result = comb(n - 1, k) * m % MOD * qpow(m - 1, n - k - 1) % MOD;
        return (int) result;
    }
}

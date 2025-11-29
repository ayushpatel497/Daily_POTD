class Q333_GFG {
    public static int countSetBits(int n) {
        if (n == 0)
            return 0;

        int x = 0;
        while ((1 << x) <= n) x++;
        x--;  // highest power of 2 <= n

        int a = x * (1 << (x - 1));       // set bits in all numbers before 2^x
        int b = n - (1 << x) + 1;         // most significant bit contribution
        int c = countSetBits(n - (1 << x)); // remaining part

        return a + b + c;
    }
}

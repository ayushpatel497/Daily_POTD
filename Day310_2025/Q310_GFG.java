class Solution {
    public int numberOfWays(int n) {
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        int lastSecond = 1;
        int last = 2;

        for (int i = 3; i <= n; i++) {
            int current = last + lastSecond;
            lastSecond = last;
            last = current;
        }

        return last;
    }
}

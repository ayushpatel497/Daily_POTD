class Q348_Leetcode {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        long count = 1;
        int seats = 0;
        int previousPairLast = -1;

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seats++;

                if (seats == 2) {
                    previousPairLast = i;
                    seats = 0;
                } 
                else if (seats == 1 && previousPairLast != -1) {
                    count = (count * (i - previousPairLast)) % MOD;
                }
            }
        }

        if (seats == 1 || previousPairLast == -1) {
            return 0;
        }

        return (int) count;
    }
}

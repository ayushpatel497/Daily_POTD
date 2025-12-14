class Solution {
public:
    int numberOfWays(string corridor) {
        // Q. Number of Ways to Divide a Long Corridor
        const int MOD = 1e9 + 7;
        long count = 1;
        int seats = 0;
        int previousPairLast = -1;
        for (int index = 0; index < corridor.length(); index++) {
            if (corridor[index] == 'S') {
                seats += 1;
                if (seats == 2) {
                    previousPairLast = index;
                    seats = 0;
                }

                else if (seats == 1 && previousPairLast != -1) {
                    count *= (index - previousPairLast);
                    count %= MOD;
                }
            }
        }

        if (seats == 1 || previousPairLast == -1) {
            return 0;
        }

        return (int) count;
    }
};
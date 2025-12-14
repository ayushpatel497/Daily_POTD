class Solution:
    def numberOfWays(self, corridor: str) -> int:
        MOD = 10**9 + 7
        count = 1
        seats = 0
        previousPairLast = -1

        for i, c in enumerate(corridor):
            if c == 'S':
                seats += 1

                if seats == 2:
                    previousPairLast = i
                    seats = 0
                elif seats == 1 and previousPairLast != -1:
                    count = (count * (i - previousPairLast)) % MOD

        if seats == 1 or previousPairLast == -1:
            return 0

        return count

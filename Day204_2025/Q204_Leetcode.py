class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        if x < y:
            x, y = y, x
            s = s[::-1]

        aCount = bCount = totalPoints = 0

        for char in s:
            if char == 'a':
                aCount += 1
            elif char == 'b':
                if aCount > 0:
                    aCount -= 1
                    totalPoints += x
                else:
                    bCount += 1
            else:
                totalPoints += min(aCount, bCount) * y
                aCount = bCount = 0

        totalPoints += min(aCount, bCount) * y

        return totalPoints

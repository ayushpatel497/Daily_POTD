class Solution:
    def calculate(self, x: str, s: str, limit: int) -> int:
        if len(x) < len(s):
            return 0
        if len(x) == len(s):
            return int(x >= s)
        
        suffix = x[-len(s):]
        count = 0
        preLen = len(x) - len(s)

        for i in range(preLen):
            digit = int(x[i])
            if limit < digit:
                count += (limit + 1) ** (preLen - i)
                return count
            count += digit * (limit + 1) ** (preLen - i - 1)

        if suffix >= s:
            count += 1
        return count

    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        return self.calculate(str(finish), s, limit) - self.calculate(str(start - 1), s, limit)

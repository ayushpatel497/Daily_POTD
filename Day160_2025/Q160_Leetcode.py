class Solution:
    def countNumbersWithPrefix(self, prefix, n):
        curr, next = prefix, prefix + 1
        count = 0
        while curr <= n:
            count += min(n + 1, next) - curr
            curr *= 10
            next *= 10
        return count

    def findKthNumber(self, n: int, k: int) -> int:
        currentPrefix = 1
        k -= 1

        while k > 0:
            count = self.countNumbersWithPrefix(currentPrefix, n)
            if k >= count:
                currentPrefix += 1
                k -= count
            else:
                currentPrefix *= 10
                k -= 1

        return currentPrefix

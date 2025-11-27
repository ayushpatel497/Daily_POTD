class Solution:
    def subsetXORSum(self, arr):
        n = len(arr)
        ans = 0

        for bit in range(11):
            countSet = 0
            for num in arr:
                if num & (1 << bit):
                    countSet += 1

            if countSet > 0:
                ans += (1 << bit) * (1 << (n - 1))

        return ans

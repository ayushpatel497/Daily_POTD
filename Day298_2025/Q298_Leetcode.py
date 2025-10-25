class Solution:
    def totalMoney(self, n: int) -> int:
        k = n // 7  # full weeks
        F = 28      # first week total (1+2+...+7)
        L = 28 + (k - 1) * 7  # last full week's total
        arithmeticSum = k * (F + L) // 2  # sum of all full weeks

        monday = 1 + k  # starting deposit for the last week
        finalWeek = 0
        for day in range(n % 7):
            finalWeek += monday + day

        return arithmeticSum + finalWeek

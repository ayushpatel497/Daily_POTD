class Solution:
    def countValid(self, n, arr):
        has_zero = 0 in arr
        total = 9 * (10 ** (n - 1))
        not_valid = (10 - len(arr)) ** n
        if not has_zero:
            not_valid -= (10 - len(arr)) ** (n - 1)
        return total - not_valid

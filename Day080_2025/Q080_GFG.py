class Solution:
    def findMaxSum(self, arr):
        n = len(arr)
        if n == 0:
            return 0
        if n == 1:
            return arr[0]

        pre1, pre2 = 0, 0
        for loot in arr:
            new_loot = loot + pre2
            pre2 = pre1
            pre1 = max(new_loot, pre1)

        return pre1

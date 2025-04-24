class Solution:
    def getSingle(self, arr):
        from collections import Counter
        count = Counter(arr)
        for num, freq in count.items():
            if freq == 1:
                return num
        return -1

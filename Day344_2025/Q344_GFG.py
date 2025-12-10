class Solution:
    def findTwoElement(self, arr):
        n = len(arr)
        freq = [0] * n
        rep = miss = -1

        for x in arr:
            freq[x - 1] += 1

        for i in range(n):
            if freq[i] == 0:
                miss = i + 1
            elif freq[i] == 2:
                rep = i + 1

        return [rep, miss]

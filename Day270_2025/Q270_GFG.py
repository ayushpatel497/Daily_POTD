from collections import deque

class Solution:
    def kBitFlips(self, arr, k):
        n = len(arr)
        flips = deque()
        count = 0

        for i in range(n):
            if flips and flips[0] + k == i:
                flips.popleft()
            if (arr[i] + len(flips)) % 2 == 0:  
                # needs flip
                if i + k > n:
                    return -1
                count += 1
                flips.append(i)

        return count

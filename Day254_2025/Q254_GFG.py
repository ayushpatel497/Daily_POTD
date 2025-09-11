class Solution:
    def minJumps(self, arr):
        n = len(arr)
        if n < 2:
            return 0
        if arr[0] == 0:
            return -1

        last = 0
        count = 0
        maxi = 0

        for i in range(n):
            maxi = max(maxi, i + arr[i])
            if i == last:
                count += 1
                last = maxi
                if last >= n - 1:
                    return count

        return -1

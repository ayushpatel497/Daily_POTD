class Solution:
    def countTriangles(self, arr):
        n = len(arr)
        cnt = 0
        arr.sort()

        for i in range(n):
            for j in range(i + 1, n):
                l, h = j + 1, n - 1
                pos = j

                while l <= h:
                    m = (l + h) // 2
                    if arr[m] < arr[i] + arr[j]:
                        pos = m
                        l = m + 1
                    else:
                        h = m - 1

                cnt += pos - j
        return cnt

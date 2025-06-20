class Solution:
    def validgroup(self, arr, k):
        arr.sort()
        n = len(arr)
        used = [False] * n

        for i in range(n):
            if used[i]:
                continue
            count = 0
            curr = arr[i]

            for j in range(i, n):
                if not used[j] and arr[j] == curr:
                    used[j] = True
                    count += 1
                    curr += 1
                if count == k:
                    break

            if count != k:
                return False

        return True

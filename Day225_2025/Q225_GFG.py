class Solution:
    def minSoldiers(self, arr, k):
        n = len(arr)
        safe_troop = (n + 1) // 2
        for i in range(n):
            arr[i] = (k - arr[i] % k) if arr[i] % k != 0 else 0
        arr.sort()
        ans = 0
        i = 0
        while safe_troop > 0:
            ans += arr[i]
            i += 1
            safe_troop -= 1
        return ans

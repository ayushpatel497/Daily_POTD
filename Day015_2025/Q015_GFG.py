class Solution:
    def longestSubarray(self, arr, k):  
        # Q. Longest Subarray with Sum K
        um = {0: -1}  # Prefix sum initialized to 0 at index -1
        ans = 0
        preSum = 0

        for i in range(len(arr)):
            preSum += arr[i]

            if preSum - k in um:
                ans = max(ans, i - um[preSum - k])

            if preSum not in um:
                um[preSum] = i

        return ans


if __name__ == "__main__":
    t = int(input())

    for _ in range(t):
        arr = list(map(int, input().split()))
        k = int(input())

        sol = Solution()
        print(sol.longestSubarray(arr, k))
        print("~")

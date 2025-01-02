class Solution:
    def countSubarrays(self, arr, k):
        # Q. Subarrays with sum K
        ans = 0
        curr_sum = 0
        prefix_sum = {0: 1}

        for num in arr:
            curr_sum += num
            if curr_sum - k in prefix_sum:
                ans += prefix_sum[curr_sum - k]
            prefix_sum[curr_sum] = prefix_sum.get(curr_sum, 0) + 1
        
        return ans


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        k = int(input())
        arr = list(map(int, input().split()))
        
        sol = Solution()
        print(sol.countSubarrays(arr, k))
        print("~")

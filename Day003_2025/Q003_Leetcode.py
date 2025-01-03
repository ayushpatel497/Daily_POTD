class Solution:
    def waysToSplitArray(self, nums: list[int]) -> int:
        # Q. Number of Ways to Split Array
        pre_sum = 0
        total = sum(nums)
        ans = 0

        for i in range(len(nums) - 1):
            pre_sum += nums[i]
            if pre_sum >= total - pre_sum:
                ans += 1

        return ans


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        nums = list(map(int, input().split()))

        sol = Solution()
        print(sol.waysToSplitArray(nums))
        print("~")

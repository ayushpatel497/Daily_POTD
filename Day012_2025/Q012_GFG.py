class Solution:
    def maxWater(self, arr):
        # Q. Trapping Rain Water
        # Two-pointer approach
        left, right = 0, len(arr) - 1
        level, water = -1, 0

        while left < right:
            if arr[left] < arr[right]:
                lower = arr[left]
                left += 1
            else:
                lower = arr[right]
                right -= 1

            level = max(level, lower)
            water += level - lower

        return water


# Example usage
if __name__ == "__main__":
    t = int(input())  # Number of test cases
    for _ in range(t):
        arr = list(map(int, input().split()))
        sol = Solution()
        print(sol.maxWater(arr))

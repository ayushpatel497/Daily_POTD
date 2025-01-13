class Solution:
    def maxWater(self, arr):
        # Q. Container With Most Water
        left = 0
        right = len(arr) - 1
        water = 0

        while left < right:
            temp_water = min(arr[left], arr[right]) * (right - left)
            water = max(water, temp_water)

            if arr[left] < arr[right]:
                left += 1
            else:
                right -= 1

        return water

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        sol = Solution()
        print(sol.maxWater(arr))
        print("~")

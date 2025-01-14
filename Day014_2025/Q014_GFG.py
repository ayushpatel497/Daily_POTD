class Solution:
    # Function to find equilibrium point in the array.
    def findEquilibrium(self, arr):
        # Q. Equilibrium Point
        total = sum(arr)
        pre_sum = 0

        for i in range(len(arr)):
            pre_sum += arr[i]
            if pre_sum - arr[i] == total - pre_sum:
                return i
        return -1


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        sol = Solution()
        print(sol.findEquilibrium(arr))
        print("~")

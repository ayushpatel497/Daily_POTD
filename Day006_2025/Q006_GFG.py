class Solution:
    def sumClosest(self, arr, target):
        # Q. Sum Pair closest to target
        n = len(arr)
        if n <= 1:
            return []

        arr.sort()
        left, right = 0, 0
        i, j = 0, n - 1
        diff = float('inf')

        while i < j:
            curr_sum = arr[i] + arr[j]
            if abs(target - curr_sum) < diff:
                diff = abs(target - curr_sum)
                left, right = arr[i], arr[j]

            if curr_sum < target:
                i += 1
            elif curr_sum > target:
                j -= 1
            else:
                return [left, right]

        return [left, right]


if __name__ == "__main__":
    t = int(input().strip())
    for _ in range(t):
        arr = list(map(int, input().split()))
        target = int(input().strip())

        sol = Solution()
        result = sol.sumClosest(arr, target)

        if not result:
            print("[]")
        else:
            print(" ".join(map(str, result)))

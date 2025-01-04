class Solution:
    def countTriplets(self, arr, target):
        # Q. Count all triplets with given sum in sorted array
        ans = 0
        n = len(arr)
        for i in range(n - 2):
            j, k = i + 1, n - 1
            while j < k:
                triplet_sum = arr[i] + arr[j] + arr[k]
                if triplet_sum == target:
                    countJ, countK = 0, 0
                    valJ, valK = arr[j], arr[k]
                    while j <= k and arr[j] == valJ:
                        countJ += 1
                        j += 1
                    while j <= k and arr[k] == valK:
                        countK += 1
                        k -= 1
                    if valJ == valK:
                        ans += countJ * (countJ - 1) // 2
                    else:
                        ans += countJ * countK
                elif triplet_sum < target:
                    j += 1
                else:
                    k -= 1
        return ans


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        target = int(input())
        sol = Solution()
        print(sol.countTriplets(arr, target))
        print("~")

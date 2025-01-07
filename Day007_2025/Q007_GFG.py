class Solution:
    def countPairs(self, arr, target):
        # Q. Pair with given sum in a sorted array
        ans = 0
        i, j = 0, len(arr) - 1

        while i < j:
            sum_ = arr[i] + arr[j]

            if sum_ == target:
                countI, countJ = 0, 0
                valI, valJ = arr[i], arr[j]

                while i <= j and arr[i] == valI:
                    countI += 1
                    i += 1
                while i <= j and arr[j] == valJ:
                    countJ += 1
                    j -= 1

                if valI == valJ:
                    ans += (countI * (countI - 1)) // 2
                else:
                    ans += countI * countJ

            elif sum_ < target:
                i += 1
            else:
                j -= 1

        return ans


# Driver code
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().strip().split()))
        target = int(input())
        obj = Solution()
        print(obj.countPairs(arr, target))
        print("~")

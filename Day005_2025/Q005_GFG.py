class Solution:
    # Complete the below function
    def countPairs(self, arr, target):
       # Q. Count Pairs whose sum is less than target
        arr.sort()  # Sort the array
        i = 0
        j = len(arr) - 1
        ans = 0

        while i < j:
            if arr[i] + arr[j] < target:
                ans += (j - i)  # Count all pairs from i to j
                i += 1
            else:
                j -= 1

        return ans


if __name__ == "__main__":
    t = int(input("Enter number of test cases: "))  # Number of test cases
    for _ in range(t):
        arr = list(map(int, input("Enter array: ").split()))  # Input array
        target = int(input("Enter target: "))  # Input target
        sol = Solution()
        print(sol.countPairs(arr, target))
        print("~")
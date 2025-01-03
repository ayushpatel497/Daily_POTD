class Solution:
    def subarrayXor(self, arr, k):
        # Q. Count Subarrays with given XOR
        prefix_xor = {0: 1}  # Initialize with XOR = 0
        curr_xor = 0
        ans = 0

        for num in arr:
            curr_xor ^= num
            if curr_xor ^ k in prefix_xor:
                ans += prefix_xor[curr_xor ^ k]
            prefix_xor[curr_xor] = prefix_xor.get(curr_xor, 0) + 1

        return ans


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        k = int(input())

        sol = Solution()
        print(sol.subarrayXor(arr, k))
        print("~")

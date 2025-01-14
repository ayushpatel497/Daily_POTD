class Solution:
    def findThePrefixCommonArray(self, A, B):
        # Q. Find the Prefix Common Array of Two Arrays
        n = len(A)
        ans = [0] * n
        freq = [0] * (n + 1)
        common = 0

        for curr_ind in range(n):
            if freq[A[curr_ind]] + 1 == 2:
                common += 1
            freq[A[curr_ind]] += 1

            if freq[B[curr_ind]] + 1 == 2:
                common += 1
            freq[B[curr_ind]] += 1

            ans[curr_ind] = common

        return ans


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        A = list(map(int, input().split()))
        B = list(map(int, input().split()))

        sol = Solution()
        result = sol.findThePrefixCommonArray(A, B)
        print(" ".join(map(str, result)))
        print("~")

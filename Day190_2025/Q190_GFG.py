class Solution:
    def sumSubMins(self, arr):
        MOD = 10**9 + 7
        n = len(arr)
        tillSum = [0] * n
        nextSmall = [-1] * n
        st = []

        for i in range(n - 1, -1, -1):
            while st and arr[st[-1]] >= arr[i]:
                st.pop()
            if st:
                nextSmall[i] = st[-1]
            st.append(i)

        ans = 0
        for i in range(n - 1, -1, -1):
            if nextSmall[i] == -1:
                tillSum[i] = arr[i] * (n - i)
            else:
                idx = nextSmall[i]
                tillSum[i] = tillSum[idx] + arr[i] * (idx - i)
            ans = (ans + tillSum[i]) % MOD

        return ans

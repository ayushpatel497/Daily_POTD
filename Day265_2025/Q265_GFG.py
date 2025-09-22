class Solution:
    def maxOfMins(self, arr):
        n = len(arr)
        nsi = [n] * n   # next smaller index
        psi = [-1] * n  # previous smaller index

        # next smaller
        st = []
        for i in range(n - 1, -1, -1):
            while st and arr[i] <= arr[st[-1]]:
                st.pop()
            if st:
                nsi[i] = st[-1]
            st.append(i)

        # previous smaller
        st.clear()
        for i in range(n):
            while st and arr[i] <= arr[st[-1]]:
                st.pop()
            if st:
                psi[i] = st[-1]
            st.append(i)

        ans = [0] * n
        for i in range(n):
            pos = nsi[i] - psi[i] - 1
            ans[pos - 1] = max(ans[pos - 1], arr[i])

        for i in range(n - 2, -1, -1):
            ans[i] = max(ans[i], ans[i + 1])

        return ans

class Solution:
    def nextLargerElement(self, arr):
        n = len(arr)
        res = [-1] * n
        st = []

        for i in range(2 * n):
            while st and arr[st[-1]] < arr[i % n]:
                res[st.pop()] = arr[i % n]
            if i < n:
                st.append(i)
        return res

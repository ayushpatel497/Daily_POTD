class Solution:
    def getArea(self, bars):
        m = len(bars)
        nse = [m] * m  # next smaller element index
        pse = [-1] * m # previous smaller element index
        st = []

        # previous smaller
        for i in range(m):
            while st and bars[st[-1]] >= bars[i]:
                st.pop()
            if st:
                pse[i] = st[-1]
            st.append(i)

        st.clear()

        # next smaller
        for i in range(m - 1, -1, -1):
            while st and bars[st[-1]] >= bars[i]:
                st.pop()
            if st:
                nse[i] = st[-1]
            st.append(i)

        area = 0
        for i in range(m):
            area = max(area, bars[i] * (nse[i] - pse[i] - 1))
        return area

    def maxArea(self, mat):
        n = len(mat)
        m = len(mat[0])
        bars = [0] * m
        ans = 0

        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    bars[j] = 0
                else:
                    bars[j] += 1
            ans = max(ans, self.getArea(bars))

        return ans

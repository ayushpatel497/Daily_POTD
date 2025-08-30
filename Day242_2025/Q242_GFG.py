class Solution:
    def celebrity(self, mat):
        n = len(mat)
        st = [i for i in range(n)]
        
        while len(st) > 1:
            a = st.pop()
            b = st.pop()
            
            if mat[a][b] == 1:
                st.append(b)  # a knows b → a cannot be celebrity
            else:
                st.append(a)  # a doesn't know b → b cannot be celebrity
        
        candidate = st.pop()
        
        # Verify candidate
        for i in range(n):
            if i != candidate and (mat[candidate][i] == 1 or mat[i][candidate] == 0):
                return -1
        return candidate

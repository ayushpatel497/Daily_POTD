import java.util.Stack;

class Q242_GFG {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            
            if (mat[a][b] == 1) {
                st.push(b);  // a knows b → a cannot be celebrity
            } else {
                st.push(a);  // a doesn't know b → b cannot be celebrity
            }
        }
        
        int candidate = st.pop();
        
        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }
}

import java.util.*;

class Q233_Leetcode {
    public int numSubmat(int[][] mat) {
        int n = mat[0].length;
        int[] heights = new int[n];
        int res = 0;

        for (int[] row : mat) {
            for (int i = 0; i < n; i++) {
                heights[i] = (row[i] == 0) ? 0 : heights[i] + 1;
            }

            Stack<int[]> st = new Stack<>();
            st.push(new int[]{-1, 0, -1});

            for (int i = 0; i < n; i++) {
                int h = heights[i];
                while (st.peek()[2] >= h) {
                    st.pop();
                }
                int[] top = st.peek();
                int j = top[0];
                int prev = top[1];
                int cur = prev + (i - j) * h;
                st.push(new int[]{i, cur, h});
                res += cur;
            }
        }
        return res;
    }
}

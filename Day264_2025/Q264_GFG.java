import java.util.*;

class Q264_GFG {
    private static int getArea(int[] bars) {
        int m = bars.length;
        int[] nse = new int[m]; // next smaller element index
        int[] pse = new int[m]; // previous smaller element index
        Arrays.fill(nse, m);
        Arrays.fill(pse, -1);

        Stack<Integer> st = new Stack<>();

        // previous smaller
        for (int i = 0; i < m; i++) {
            while (!st.isEmpty() && bars[st.peek()] >= bars[i]) {
                st.pop();
            }
            if (!st.isEmpty()) pse[i] = st.peek();
            st.push(i);
        }

        st.clear();

        // next smaller
        for (int i = m - 1; i >= 0; i--) {
            while (!st.isEmpty() && bars[st.peek()] >= bars[i]) {
                st.pop();
            }
            if (!st.isEmpty()) nse[i] = st.peek();
            st.push(i);
        }

        int area = 0;
        for (int i = 0; i < m; i++) {
            area = Math.max(area, bars[i] * (nse[i] - pse[i] - 1));
        }
        return area;
    }

    static int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;

        int[] bars = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) bars[j] = 0;
                else bars[j]++;
            }
            ans = Math.max(ans, getArea(bars));
        }
        return ans;
    }
}

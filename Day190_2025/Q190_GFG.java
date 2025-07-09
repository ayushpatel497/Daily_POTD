import java.util.*;

class Q190_GFG {
    public int sumSubMins(int[] arr) {
        int MOD = (int)1e9 + 7;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] tillSum = new int[n];
        int[] nextSmall = new int[n];
        Arrays.fill(nextSmall, -1);
        
        // Next smaller element indices
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nextSmall[i] = st.peek();
            }
            st.push(i);
        }

        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nextSmall[i] == -1) {
                tillSum[i] = arr[i] * (n - i);
            } else {
                int idx = nextSmall[i];
                tillSum[i] = tillSum[idx] + arr[i] * (idx - i);
            }
            ans = (ans + tillSum[i]) % MOD;
        }

        return (int) ans;
    }
}

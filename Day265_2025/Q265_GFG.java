import java.util.*;

class Q265_GFG {
    private void setNextSmallerFun(int[] arr, int[] nsi) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) nsi[i] = n;
            else nsi[i] = st.peek();
            st.push(i);
        }
    }

    private void setPrevSmallerFun(int[] arr, int[] psi) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) psi[i] = -1;
            else psi[i] = st.peek();
            st.push(i);
        }
    }

    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] nsi = new int[n];
        int[] psi = new int[n];
        Arrays.fill(nsi, n);
        Arrays.fill(psi, -1);

        setNextSmallerFun(arr, nsi);
        setPrevSmallerFun(arr, psi);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = nsi[i] - psi[i] - 1;
            ans[pos - 1] = Math.max(ans[pos - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int val : ans) result.add(val);
        return result;
    }
}

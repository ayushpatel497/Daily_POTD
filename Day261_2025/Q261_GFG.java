import java.util.*;

class Q261_GFG {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = arr[i % n];
            while (!st.isEmpty() && arr[st.peek()] < num) {
                result.set(st.pop(), num);
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }
}
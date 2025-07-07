import java.util.*;

class Q188_GFG {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();

        // Traverse the array twice to simulate circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int curr = arr[i % n];
            while (!st.isEmpty() && arr[st.peek()] < curr) {
                result.set(st.pop(), curr);
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }
}

import java.util.*;

class Q054_GFG {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        // Process elements from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If current element is less than the top of stack, that's the next greater
            if (arr[i] < st.peek()) {
                ans.set(i, st.peek());
                st.push(arr[i]);
            } else {
                // Pop until finding a greater element or reaching -1
                while (st.peek() != -1 && arr[i] >= st.peek()) {
                    st.pop();
                }
                ans.set(i, st.peek());
                st.push(arr[i]);
            }
        }
        return ans;
    }
}

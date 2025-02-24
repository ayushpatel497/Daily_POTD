import java.util.*;

class Q055_GFG {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> answer = new ArrayList<>(Collections.nCopies(n, 1));
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                answer.set(i, answer.get(i) + answer.get(st.peek()));
                st.pop();
            }
            st.push(i);
        }
        return answer;
    }
}

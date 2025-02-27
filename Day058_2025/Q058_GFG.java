import java.util.Stack;

class Q058_GFG {
    private Stack<Long> st;
    private long mini;

    public Q058_GFG() {
        st = new Stack<>();
        mini = Integer.MAX_VALUE;
    }

    // Add an element to the top of Stack
    public void push(int x) {
        long val = (long) x;
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        } else {
            if (val < mini) {
                st.push(2 * val - mini);
                mini = val;
            } else {
                st.push(val);
            }
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (st.isEmpty()) return;
        long element = st.pop();
        if (element < mini) {
            mini = 2 * mini - element;
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (st.isEmpty()) return -1;
        long element = st.peek();
        return (element < mini) ? (int) mini : (int) element;
    }

    // Finds minimum element of Stack
    public int getMin() {
        return st.isEmpty() ? -1 : (int) mini;
    }
}

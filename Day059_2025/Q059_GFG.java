import java.util.Stack;

class Q059_GFG{
    public int evaluate(String[] arr) {
        Stack<Integer> st = new Stack<>();

        for (String token : arr) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                st.push(Integer.parseInt(token));
            } else {
                int x = st.pop();
                int y = st.pop();

                if (token.equals("+")) {
                    st.push(y + x);
                } else if (token.equals("-")) {
                    st.push(y - x);
                } else if (token.equals("*")) {
                    st.push(y * x);
                } else {
                    st.push(y / x);
                }
            }
        }

        return st.pop();
    }
}

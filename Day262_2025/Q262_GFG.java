import java.util.Stack;

class Q262_GFG {
    public int minParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    ans++;
                } else {
                    st.pop();
                }
            }
        }
        ans += st.size();
        return ans;
    }
}

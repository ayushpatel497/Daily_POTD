import java.util.*;

class Q260_GFG {
    static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            } else {
                StringBuilder temp = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                st.pop();  // Remove '['
                temp.reverse();
                
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }
                int number = Integer.parseInt(num.toString());
                
                StringBuilder t = new StringBuilder();
                for (int j = 0; j < number; j++) {
                    t.append(temp);
                }
                
                for (char c : t.toString().toCharArray()) {
                    st.push(c);
                }
            }
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return new StringBuilder(ans).reverse().toString();
    }
}

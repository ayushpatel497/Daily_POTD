import java.util.*;

class Q259_GFG {
    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (String token : arr) {
            if (token.equals("+") || token.equals("-") || token.equals("*") 
                || token.equals("/") || token.equals("^")) {
                
                int op2 = st.pop();
                int op1 = st.pop();
                int res = 0;
                
                switch (token) {
                    case "+": res = op1 + op2; break;
                    case "-": res = op1 - op2; break;
                    case "*": res = op1 * op2; break;
                    case "/": res = op1 / op2; break;  // Integer division
                    case "^": res = (int) Math.pow(op1, op2); break;
                }
                
                st.push(res);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        
        return st.peek();
    }
}

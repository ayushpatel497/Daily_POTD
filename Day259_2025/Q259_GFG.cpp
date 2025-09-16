class Solution {
  public:
    int evaluatePostfix(vector<string>& arr) {
        // Q. Postfix Evaluation
        // code here
        stack<int> st;
        
        for(auto& token : arr) {
            if(token == "+" || token == "-" || token == "*" || token == "/" || token == "^") {
                int op2 = st.top(); st.pop();
                int op1 = st.top(); st.pop();
                
                int res;
                switch(token[0]) {
                    case '+': res = op1 + op2; break;
                    case '-': res = op1 - op2; break;
                    case '*': res = op1 * op2; break;
                    case '/': res = floor((double)op1 / op2); break;
                    case '^': res = pow(op1, op2); break;
                }
                
                st.push(res);
            }
            else {
                st.push(stoi(token));
            }
        }
        
        return st.top();
    }
};
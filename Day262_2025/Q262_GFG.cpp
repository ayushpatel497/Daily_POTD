class Solution {
  public:
    int minParentheses(string& s) {
        // Q. Min Add to Make Parentheses Valid
        // code here
        int n = s.size();
        stack<char> st;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '(') st.push('(');
            else{
                if(st.empty()) ans++;
                else{
                    st.pop();
                }
            }
        }
        
        if(!st.empty()) ans += st.size();
        
        return ans;
    }
};
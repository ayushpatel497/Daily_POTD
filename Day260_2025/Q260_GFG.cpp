class Solution {
  public:
    string decodedString(string &s) {
        // Q. Decode the string
        // code here
        stack<char> st;
        int n = s.size();
        string ans = "";
       
        for(int i = 0; i < n; i++){
            if(s[i] != ']'){
                st.push(s[i]);
            }
            else{
                string temp = "";
                while(!st.empty() && st.top() != '['){
                    temp += st.top();
                    st.pop();
                }
                st.pop();
                reverse(temp.begin(), temp.end());
                string num;
                while(!st.empty() && isdigit(st.top())){
                    num = st.top() + num;
                    st.pop();
                }
                int number = stoi(num);
                string t = "";
                for(int i = 0; i < number; i++)
                    t += temp;
                for(char c : t)
                    st.push(c);
           }
           
        }
        while(!st.empty()){
            ans += st.top();
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
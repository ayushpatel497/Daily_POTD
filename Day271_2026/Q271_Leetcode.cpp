class Solution {
public:
    int maxDepth(string s) {
        // Q. Maximum Nesting Depth of the Parentheses
        int ans = 0;
        int openBrackets = 0;

        for (char c : s) {
            if (c == '(') {
                openBrackets++;
            } else if (c == ')') {
                openBrackets--;
            }
            
            ans = max(ans, openBrackets);
        }
        
        return ans;
    }
};
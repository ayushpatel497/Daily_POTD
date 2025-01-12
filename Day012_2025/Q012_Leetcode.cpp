class Solution {
public:
    bool canBeValid(string s, string locked) {
        // Q. Check if a Parentheses String Can Be Valid
        int n = s.length();
        int minOpen = 0, maxOpen = 0;
        for (int i = 0; i < n; i++) {
            if (locked[i] == '0') {
                maxOpen++;
                minOpen = minOpen == 0 ? 1 : minOpen - 1;
            } 
            else {
                if (s[i] == '(') {
                    minOpen++;
                    maxOpen++;
                } 
                else {
                    maxOpen--;
                    minOpen = minOpen == 0 ? 1 : minOpen - 1;
                    if (minOpen > maxOpen) {
                        return false;
                    }
                }
            }
        }
        return minOpen == 0;
    }
};
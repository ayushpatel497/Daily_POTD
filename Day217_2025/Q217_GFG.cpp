class Solution {
  public:
    bool isPalinSent(string &s) {
        // Q. Palindrome Sentence
        // code here
        int j = s.size() - 1;
        int i = 0;
        while (i <= j){
            char curr_i = tolower(s[i]);
            char curr_j = tolower(s[j]);
            if (iswalnum(curr_i) && iswalnum(curr_j) && curr_i == curr_j){
                i++;
                j--;
            }
            else if (iswalnum(curr_i) && iswalnum(curr_j) && curr_i != curr_j){
                return false;
            }
            else if (iswalnum(curr_i)){
                j--;
            }
            else if (iswalnum(curr_j)){
                i++;
            }
            else {
                i++;
                j--;
            }
        }
        
        return true;
    }
};
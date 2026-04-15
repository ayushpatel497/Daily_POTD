class Solution {
  public:
    string URLify(string &s) {
        // Q. URLify a given string
        // code here
        string result = "";
        for(char ch : s) {
            if(ch == ' ') {
                result += "%20";
            }
            else {
                result += ch;
            }
        }
        
        return result;
    }
};
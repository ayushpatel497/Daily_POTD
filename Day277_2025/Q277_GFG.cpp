class Solution {
    void help(string &s, int &target, int index, vector<string> &ans, int value, int pichli, string newString){
        if(index == s.length()){
            if(value == target){
                ans.push_back(newString);
            }
            return;
        }
        string temp = "";
        int n = 0;
        for(int i = index; i < s.length(); i++){
            temp += s[i];
            n = n * 10 + (s[i] - '0');
            if(index == 0){
                help(s, target, i + 1, ans, n, n, temp);
            }
            else{
                help(s, target, i + 1, ans, value + n, n, newString + "+" + temp);
                help(s, target, i + 1, ans, value - n, -n, newString + "-" + temp);
                help(s, target, i + 1, ans, value - pichli + pichli * n, pichli * n, newString + "*" + temp);
            }
            if(s[index] == '0')break;
        }
    }
  public:
    vector<string> findExpr(string &s, int target) {
        // Q. Expression Add Operators
        // code here
        vector<string> ans;
        help(s, target, 0, ans, 0, 0, "");
        return ans;
    }
};
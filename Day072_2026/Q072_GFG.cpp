class Solution {
    bool isvalid(string &s){
        int n = s.length();
        if(n == 0) return false;
        if(n > 3) return false;
        if(s[0] == '0' && n > 1) return false;
        int temp = stoi(s);
        if(temp > 255) return false;
        return true;
    }
  public:
    vector<string> generateIp(string &s) {
        // Q. Generate IP Addresses
        // code here
        vector<string> ans;
        int n = s.length();
        if(n > 12){
            ans.push_back("-1");
            return ans;
        }
        
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    string a = s.substr(0, i + 1);
                    string b = s.substr(i + 1, j - i);
                    string c = s.substr(j + 1, k - j);
                    string d = s.substr(k + 1);
                    if(isvalid(a) && isvalid(b) && isvalid(c) && isvalid(d)){
                        ans.push_back(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return ans;
    }
};
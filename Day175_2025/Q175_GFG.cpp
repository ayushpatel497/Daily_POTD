class Solution {
  public:
    string maxSubseq(string& s, int k) {
        // Q. Lexicographically Largest String After K Deletions
        // code here
        int n = s.size();
        int keep = n - k;
        string ans;

        for (char ch : s) {
            while (!ans.empty() && k > 0 && ans.back() < ch) {
                ans.pop_back();
                k--;
            }
            ans.push_back(ch);
        }
        ans.resize(keep);
        return ans;
    }
};

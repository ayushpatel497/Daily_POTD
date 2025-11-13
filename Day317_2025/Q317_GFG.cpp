class Solution {
    bool helper(int i, int j, int k, string &s1, string &s2, string &s3){
        if(i>=s1.size() && j>=s2.size() && k>=s3.size()){
            return true;
        }
        if(i<s1.size() && k<s3.size() && s1[i] == s3[k]){
            if(helper(i+1, j, k+1, s1, s2, s3))return true;
        }
        if(j<s2.size() && k<s3.size() && s2[j] == s3[k]){
            if(helper(i, j+1, k+1, s1, s2,s3))return true;
        }
        return false;
    }
  public:
    bool isInterleave(string &s1, string &s2, string &s3) {
        // Q. Interleaved Strings
        // code here
        if(s1.size() + s2.size() != s3.size()) return false;
        return helper(0, 0, 0, s1, s2, s3);
    }
};
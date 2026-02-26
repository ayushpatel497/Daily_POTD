class Solution {
  public:
    bool areIsomorphic(string &s1, string &s2) {
        // Q. Isomorphic Strings
        // code here
        unordered_map<char, char> mpp1, mpp2;
        for(int i = 0; i < s1.size(); i++){
            if(mpp1.find(s1[i]) != mpp1.end() && mpp1[s1[i]] != s2[i]) return false;
            if(mpp2.find(s2[i]) != mpp2.end() && mpp2[s2[i]] != s1[i]) return false;
            mpp1[s1[i]] = s2[i];
            mpp2[s2[i]] = s1[i];
        }
        return true;
    }
};
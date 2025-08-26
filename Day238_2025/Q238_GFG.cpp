class Solution {
  public:
    bool isSubSeq(string& s1, string& s2) {
        // Q. Check if a String is Subsequence of Other
        // code here
        bool ans = true;
        int n = s1.size();
        int m = s2.size();
        int p1 =0 , p2 = 0;
        while(p1 < n && p2 < m){
            if(s1[p1] == s2[p2]) {
                p1++;
            }
            p2++;
        }
        if(p1 != n) ans = false;
        return ans;
    }
};
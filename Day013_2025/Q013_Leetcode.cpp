class Solution {
public:
    int minimumLength(string s) {
        // Q. Minimum Length of String After Operations
        vector<int> freq(26, 0);
        for(int i = 0; i < s.length(); ++i){
            freq[s[i] - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < 26; ++i){
            if(freq[i] > 0){
                if(freq[i] & 1){
                    ans += 1;
                }
                else{
                    ans += 2;
                }
            }
        }
        return ans;
    }
};
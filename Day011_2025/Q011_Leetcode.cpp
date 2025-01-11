class Solution {
public:
    bool canConstruct(string s, int k) {
        // Q. Construct K Palindrome Strings
        if(s.length() < k){
            return false;
        }
        vector<int> freq(26, 0);
        for(int i = 0; i < s.length(); ++i){
            freq[s[i] - 'a']++;
        }
        int odds = 0;
        for(int i = 0; i < 26; ++i){
            if(freq[i] & 1){
                odds++;
            }
        }
        return odds <= k;
    }
};
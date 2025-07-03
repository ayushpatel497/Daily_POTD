class Solution {
  public:
    int longestKSubstr(string &s, int k) {
        // Q. Longest Substring with K Uniques
        // code here
        vector<int> freq(26,0);
        int cnt = 0;
        int st = 0;
        int ans = -1;
        for(int i = 0 ; i < s.length() ; i++){
            if(freq[s[i]-'a']++ == 0){
                cnt++;
                if(cnt > k){
                    ans  = max(ans,i - st);
                    while(st < i){
                        if(--freq[s[st++]-'a'] == 0){
                            cnt--;
                            break;
                        }
                    }
                }
            }
        }
        int n = s.length();
        if(cnt >= k)  ans  = max(ans,n - st);
        return ans;
    }
};
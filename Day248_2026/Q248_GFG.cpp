class Solution {
  public:
    int longestSubseq(vector<int>& arr) {
        // Q. Longest Subsequence with Adjacent Diff as 1
        // code here
        int n = arr.size();
        unordered_map<int, int> mp;
        vector<pair<int, int>> v(n, {0, 0});
        for(int i = n - 1; i >= 0; i--){
            int a = arr[i];
            if(mp.find(a - 1) != mp.end()){
                v[i].first = mp[a - 1];
            }
            if(mp.find(a + 1) != mp.end()){
                v[i].second = mp[a + 1];
            }
            mp[arr[i]] = i;
        }
        queue<int> q;
        for(int i = 0; i < arr.size(); i++){
            q.push(i);
        }
        q.push(-1);
        int cnt = 0;
        while(!q.empty()){
            int a = q.front();
            q.pop();
            if(a == -1){
                if(!q.empty()){
                    q.push(-1);
                }
                cnt++;
                continue;
            }
            pair<int,int> w = v[a];
            if(w.first != 0){
               q.push(w.first);
            }
            if(w.second != 0){
               q.push(w.second);
            }
        }
        return cnt;
    }
};
class Solution {
  public:
    vector<int> topKFreq(vector<int> &arr, int k) {
        // Q. Top K Frequent in Array
        // Code here
        int N = arr.size();
        unordered_map<int, int> mp;
        for (int i = 0; i < N; i++) 
            mp[arr[i]]++;
        priority_queue<pair<int, int> > pq;
        for (auto x : mp) 
            pq.push({ x.second, x.first });
        vector<int> ans;
        for (int i = 1; i <= k; i++) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }
};

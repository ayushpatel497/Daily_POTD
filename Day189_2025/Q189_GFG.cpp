class Solution {
  public:
    vector<int> findGreater(vector<int>& arr) {
        // Q. Next element with greater frequency
        // code here
        int n = arr.size();
        map<int, int> freq;
        for (auto it : arr) {
            freq[it]++;
        }
        vector<int> res(n, -1);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && freq[arr[i]] > freq[arr[s.top()]]) {
                res[s.top()] = arr[i];
                s.pop();
            }
            s.push(i);
        }
        return res;
    }
};

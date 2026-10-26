class Solution {
  public:
    int minDiff(int k, vector<int> &arr) {
        // Q. Minimize Max Min Diff with Subarray Removal
        // code here
        if(k >= arr.size()){
            return 0;
        }
        map<int, int> mp;
        for(int i = k; i < arr.size(); i++){
            mp[arr[i]]++;
        }
        int ans = mp.rbegin()-> first - mp.begin()-> first;
        for(int i = 0, j = k; j < arr.size(); j++, i++){
            mp[arr[i]]++;
            if(mp[arr[j]] == 1){
                mp.erase(arr[j]);
            }
            else{
                mp[arr[j]]--;
            }
            ans = min(ans, mp.rbegin()-> first - mp.begin()-> first);
        }
        return ans;
    }
};

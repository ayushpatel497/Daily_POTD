class Solution {
  public:
    int catchThieves(vector<char> &arr, int k) {
        // Q. Police and Thieves
        // Code here
        int ans = 0;
        deque<pair<char, int>> dq;
        for(int i = 0; i < arr.size(); i++){
            if(dq.empty() == true or dq.front().first == arr[i]){
                dq.push_back({arr[i], i});
            }
            else{
                while(dq.front().second < (i - k)){
                    dq.pop_front();
                }
                ans++;
                dq.pop_front();
            }
        }
        
        return ans;
    }
};
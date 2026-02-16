class Solution {
    static bool cmp(vector<int>& first,vector<int>& second){
        if(first[1] == second[1]) return first[0] <= second[0];
        return first[1] < second[1];
    }
  public:
    bool canAttend(vector<vector<int>> &arr) {
        // Q. Meeting Rooms
        // Code Here
        sort(arr.begin(), arr.end(), cmp);
        
        int n = arr.size();
        if(n == 1) return true;
        
        for(int i = 1; i < n; i++){
            int prevEnd = arr[i - 1][1];
            int currentStart = arr[i][0];
            if(prevEnd > currentStart) return false;
        }
        
        return true;
    }
};
class Solution {
  public:
    int minSubsets(vector<int>& arr) {
        // Q. Split Array into Minimum Subsets
        // code here
        sort(arr.begin(),arr.end());
        unordered_map<int,bool> t;
        for(int i : arr){
            if(t.find(i - 1) == t.end()){
                t[i] = true;
            }else{
                t[i] = true;
                t.erase(i-1);
            }
        }
        
        return t.size();
    }
};

class Solution {
  public:
    vector<int> countLessEq(vector<int>& a, vector<int>& b) {
        // Q. Counting elements in two arrays
        // code here
        sort(b.begin(),b.end());
        vector<int>ans;
        for(auto it:a){
            int start = 0;
            int end = b.size() - 1;
            int mid = start + (end - start) / 2;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(b[mid] <= it){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            ans.push_back(end + 1);
        }
        return ans;
    }
};
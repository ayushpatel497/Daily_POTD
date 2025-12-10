class Solution {
  public:
    vector<int> findTwoElement(vector<int>& arr) {
        // code here
        int rep, miss;
        int n = arr.size();
        vector<int> v(n,0);
        for(int i = 0; i < n; i++){
            v[arr[i] - 1]++;
        }
        for(int i = 0; i < n; i++){
            if(v[i] == 0)
                miss = i + 1;
            else if(v[i] == 2)
                rep = i + 1;
        }
        return {rep, miss};
    }
};
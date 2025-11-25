class Solution {
  public:
    int subarrayXor(vector<int>& arr) {
        // Q. Game of XOR
        // code here
        int N = arr.size();
        if(N % 2 == 0) 
            return 0;
        int ans = 0;
        for(int i = 0; i < N; i += 2) 
            ans ^= arr[i];
        return ans;
    }
};
class Solution {
  public:
    vector<int> lexicographicallyLargest(vector<int> &arr) {
        // Q. Largest with Same Parity Adjacent Swaps
        // code here
        vector<int>res = arr;
        int par = res[0] &1 , st = 0;
        for(int i = 1 ; i<arr.size() ; i++){
            if(par != (res[i]&1)){
                sort(res.begin() + st , res.begin() + i , greater<int>());
                par ^=1;
                st = i;
            }
        }
        sort(res.begin() +st , res.end() , greater<int>());
        return res;
    }
};
class Solution {
    void gen(vector<string>&vec , int n){
        if(n == 1)return;
        int h = vec.size();
        for(int i = h-1; i >=0 ; i--){
            vec.push_back('1' + vec[i]);
            vec[i] = '0' + vec[i];
        }
        gen(vec , n-1);
  }
  public:
    vector<string> graycode(int n) {
        // Q. Gray Code
        // code here
        vector<string>res = {"0" , "1"};
        gen(res , n);
        return res;
    }
};
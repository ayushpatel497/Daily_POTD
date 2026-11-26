class Solution {
  public:
    vector<int> countVowels(string &s, vector<vector<int>> &queries) {
        // Q. Range Vowel Count Queries
        // code here
        vector<int> vec(s.size());
        int cnt = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == 'a'|| s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')cnt++;
            vec[i] = cnt;
        }
        vector<int>ans;
        for(auto it : queries){
            int left = it[0] - 1 >= 0 ? vec[it[0] - 1] : 0;
            int right = vec[it[1]];
            ans.push_back(right - left);
        }
        return ans;
    }
};
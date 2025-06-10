class Solution {
  public:
    int countStrings(string &s) {
        // Q. Exactly one swap
        // code here
        int arr[256] = {0};
        int count = 0;
        bool flag = false;
        for(int i = 0; i < s.size(); i++){
            count += s.size() - i - 1;
            count -= arr[s[i]];
            if(arr[s[i]] != 0)flag = true;
            arr[s[i]]++;
        }
        return count + flag;
    }
};

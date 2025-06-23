class Solution {
  public:
    string minSum(vector<int> &arr) {
        // Q. Minimum sum
        // code here
        sort(arr.begin() , arr.end());
        int n = arr.size() , carry = 0;
        string ans;
        for(int i = n - 1; i >= 0; i -= 2)
        {
            int a = arr[i];
            int b = (i > 0) ? arr[i - 1] : 0;
            int sum = (a + b + carry);
            int ld = sum % 10;
            ans.push_back(ld + '0');
            carry = sum / 10;
        }
        if(carry)
            ans.push_back(carry + '0');
        while(ans.back() == '0')
            ans.pop_back();
        reverse(ans.begin() , ans.end());
        return ans;
    }
};
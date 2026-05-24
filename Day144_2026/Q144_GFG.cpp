class Solution {
  public:
    int coin(vector<int>& arr) {
        // Q. Last Coin in a Game of Alternates
        // code here
        return *min_element(arr.begin(), arr.end());
    }
};
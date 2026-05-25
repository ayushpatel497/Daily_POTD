class Solution {
  public:
    bool checkElements(int start, int end, vector<int> &arr) {
        // Q. Elements in the Range
        // code here
        int cnt = 0;
        for(auto& i: arr) {
            if(i >= start and i <= end) cnt++;
        }
        return cnt == end - start + 1;
    }
};

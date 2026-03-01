class Solution {
  public:
    void pushZerosToEnd(vector<int>& arr) {
        // Q. Move All Zeroes to End
        // code here
        int l = 0, sizeOfArr = arr.size();
        for (int i = 0; i < sizeOfArr; i++) {
            if (arr[i]) {
                swap(arr[i], arr[l++]);
            }
        }
    }
};
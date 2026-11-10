class Solution {
  public:
    int firstElementKTime(vector<int>& arr, int k) {
        // Q. At Least K Occurrences
        // code here
        unordered_map<int, int> freq;
        for (int num : arr) {
            freq[num]++;
            if (freq[num] == k) {
                return num;
            }
        }
        return -1;
    }
};
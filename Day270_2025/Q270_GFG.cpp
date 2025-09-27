class Solution {
  public:
    int kBitFlips(vector<int>& arr, int k) {
        // Q. Minimum K Consecutive Bit Flips
        // code here
        int n = arr.size();
        queue<int> flips;
        int count = 0;
    
        for (int i = 0; i < n; i++) {
            if (!flips.empty() && flips.front() + k == i) {
                flips.pop();
            }
            if ((arr[i] + flips.size()) % 2 == 0) {
                if (i + k > n) return -1;
                count++;
                flips.push(i);
            }
        }
    
        return count;
    }
};
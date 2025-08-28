class Solution {
  public:
    int maxOnes(vector<int>& arr, int k) {
        // Q. Maximize Number of 1's
        // code here
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < arr.size(); right++) {
            if (arr[right] == 0) 
                zeroCount++;
            while (zeroCount > k) {
                if (arr[left] == 0) 
                    zeroCount--;
                left++;
            }
            maxLen = max(maxLen, right - left + 1);
        }
        return maxLen;
    }
};

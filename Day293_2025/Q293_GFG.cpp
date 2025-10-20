class Solution {
  public:
    vector<int> countBSTs(vector<int>& arr) {
        // Q. Number of BST From Array
        // Code here
        vector<int> numWays(7);
        numWays[0] = 1;
        numWays[1] = 1;
        
        for (int index = 2; index < numWays.size(); index++) {
            int left = 0;
            int right = index - 1;
            
            int sum = 0;
            while (left <= right) {
                int product = numWays[left] * numWays[right];
                sum += product * (1 + (left != right));
                left++;
                right--;
            }
            numWays[index] = sum;
        }
        
        unordered_map<int, int> valueToIndex;
        for (int index = 0; index < arr.size(); index++) {
            valueToIndex[arr[index]] = index;
        }
        
        vector<int> sortedInput = arr;
        sort(sortedInput.begin(), sortedInput.end());
        
        vector<int> result(arr.size());
        for (int index = 0; index < sortedInput.size(); index++) {
            int original = valueToIndex[sortedInput[index]];
            result[original] = numWays[index] * numWays[arr.size() - index - 1];
            
        }
        
        return result;
    }
};
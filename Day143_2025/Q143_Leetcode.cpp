class Solution {
public:
    long long maximumValueSum(vector<int>& nums, int k, vector<vector<int>>& edges) {
        // Q. Find the Maximum Sum of Node Values
        long long sum = 0;
        int count = 0, positiveMinimum = (1 << 30), negativeMaximum = -1 * (1 << 30);
            
        for (int nodeValue : nums) {
            int operatedNodeValue = nodeValue ^ k;
            sum += nodeValue;
            int netChange = operatedNodeValue - nodeValue;
            
            if (netChange > 0) {
                positiveMinimum = min(positiveMinimum, netChange);
                sum += netChange;
                count++;
            } else {
                negativeMaximum = max(negativeMaximum, netChange);
            }
        }
        if (count % 2 == 0) {
            return sum;
        }
        return max(sum - positiveMinimum, sum + negativeMaximum);
    }
};